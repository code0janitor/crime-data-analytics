package org.code.janitor.mdp.conf;

import static org.code.janitor.mdp.AppConstants.INPUT_FILE_PATTERN;
import static org.code.janitor.mdp.AppConstants.READ_CHUNK_SIZE;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.code.janitor.mdp.AppConstants;
import org.code.janitor.mdp.bean.ConvertProcessor;
import org.code.janitor.mdp.dto.Incident;
import org.code.janitor.mdp.dto.Row;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

	
	
	@Value("${mongodb.database.collection}")
	private String mongoCollectionName;

	
	@Value("${data.input.file.path}")
	private String inputFilePath;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public Job readFile() {
		return jobBuilderFactory.get("READ-CSV-FILE")
				.incrementer(new RunIdIncrementer())
				.start(readConvertAndWrite())
				.build();
	}

	@Bean
	public Step readConvertAndWrite() {
		return stepBuilderFactory.get("READ-CONVERT-WRITE")
				.<Row, Incident>chunk(READ_CHUNK_SIZE)
				/*.reader(new ClassPathResource("<file-name>"));*/
				.reader(reader())
				.processor(processor())
				.writer(writer()).build();
	}

	@Bean
	public ItemProcessor<Row, Incident> processor() {
		return new ConvertProcessor();
	}

	@Bean
	public FlatFileItemReader<Row> reader() {
		FlatFileItemReader<Row> reader = new FlatFileItemReader<>();
		reader.setResource(getResource());
		reader.setLinesToSkip(1);
		reader.setLineMapper(new DefaultLineMapper<Row>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(AppConstants.INPUT_FILE_HEADERS);

					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Row>() {
					{
						setTargetType(Row.class);
					}
				});
			}
		});
		return reader;

	}

	@Bean
	public MongoItemWriter<Incident> writer() {
		MongoItemWriter<Incident> writer = new MongoItemWriter<Incident>();
		writer.setTemplate(mongoTemplate);
		writer.setCollection(mongoCollectionName);
		return writer;
	}

	private Resource getResource() {
		FileSystemResource fsr = null;

		if (!StringUtils.isBlank(inputFilePath)) {

			File file = new File(inputFilePath);

			if (file.exists() && !file.isDirectory())
			{
				fsr = new FileSystemResource(file);
			}
			else if(file.isDirectory()) {
			/*
			 * get the first csv file from this directory
			 */
				for (File cFile : file.listFiles())
				if (cFile.getName().endsWith(INPUT_FILE_PATTERN)) {
					fsr = new FileSystemResource(cFile);
					break;
				}
			}
		}
		return fsr;

	}
}
