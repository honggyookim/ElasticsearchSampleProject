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
	 * - Annotation ����� ȯ�� ������ ���� ����� �Ѵ�.
	 * - �ش� annotation�� ����� Ŭ������ �ϳ� �̻��� @Bean �޼ҵ带 �����ϰ�, �����̳ʴ� Bean��
	 *   �����ϰ�, ��Ÿ�� �� �ش� Bean���� ��û�� ó���ϰ� �ȴ�.
	 * @Value
	 * - properties ���Ϸκ��� �������� ���� �� ����Ѵ�.
	 * - root-context.xml�� properties�� ���� �� �ֵ��� �����ϰ�, 
	 *   Ŭ�������� �ش� properties ���Ϸκ��� �� annotation�� �����Ͽ� ������Ƽ�� ����� �� �ִ�.    
	 */
	
	@Value("${elasticsearch.host}")
	private String host;
	
	@Value("${elasticsearch.port}")
	private int port;

	/**
	 * ������ ���Ǵ� TransportClient�� 7.0.0���� Deprecated�Ǿ���, 8.0.x������ ���ŵȴ�.
	 * RestHighLevelClient������ ���� cluster-name�� �������� �ʾƵ� �ȴ�.
	 */
	
	@Bean
	public RestHighLevelClient getRestClient() {
		logger.debug("host is {}, port is {}", host, port);
		RestClientBuilder builder = RestClient.builder(new HttpHost(host, port, "http"));
		return new RestHighLevelClient(builder);
	}

}
