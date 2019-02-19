package kr.co.ensecure.piias.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
	private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);
	
	/**
	 * @Configuration
	 * - Annotation 기반의 환경 설정을 돕는 기능을 한다.
	 * - 해당 annotation을 사용한 클래스가 하나 이상의 @Bean 메소드를 정의하고, 컨테이너는 Bean을
	 *   생성하고, 런타임 시 해당 Bean들이 요청을 처리하게 된다.
	 * @Value
	 * - properties 파일로부터 설정값을 읽을 때 사용한다.
	 * - root-context.xml에 properties를 읽을 수 있도록 선언하고, 
	 *   클래스에서 해당 properties 파일로부터 이 annotation을 선언하여 프로퍼티를 사용할 수 있다.    
	 */
	
	@Value("${elasticsearch.host}")
	private String host;
	
	@Value("${elasticsearch.port}")
	private int port;

	/**
	 * 기존에 사용되던 TransportClient는 7.0.0에서 Deprecated되었고, 8.0.x에서는 제거된다.
	 * RestHighLevelClient에서는 따로 cluster-name을 설정하지 않아도 된다.
	 */
	
	@Bean
	public RestHighLevelClient getRestClient() {
		logger.debug("host is {}, port is {}", host, port);
		RestClientBuilder builder = RestClient.builder(new HttpHost(host, port, "http"));
		return new RestHighLevelClient(builder);
	}

}
