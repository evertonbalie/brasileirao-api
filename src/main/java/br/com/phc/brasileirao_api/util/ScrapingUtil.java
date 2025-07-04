package br.com.phc.brasileirao_api.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.phc.brasileirao_api.dto.PartidaGoogleDTO;

public class ScrapingUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScrapingUtil.class);
//	private static final String BASE_URL_GOOGLE = "https://www.google.com.br/search?q=";
//	private static final String COMPLEMNTO_URL_GOOGLE = "&hl=pt-BR";
//	

	private static final String BASE_URL_GOOGLE = "https://www.google.com.br/search?q=";
	private static final String COMPLEMENTO_URL_GOOGLE = "&hl=pt-BR";

	public static void main(String[] args) {

		String url = BASE_URL_GOOGLE + "palmeiras e corinthians+08/08/2020" + COMPLEMENTO_URL_GOOGLE;
		//String url =" https://www.amazon.com.br/";

		ScrapingUtil scraping = new ScrapingUtil();

		scraping.obterInformacaoPartida(url);

	}

	private PartidaGoogleDTO obterInformacaoPartida(String url) {
		PartidaGoogleDTO partida = new PartidaGoogleDTO();

		Document document = null;
		
		

		try {
			document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
				    .timeout(10 * 1000)
				    .get();
;
			String title = document.title();
			LOGGER.info("Titulo da pagina: {}",title);
			
		} catch (IOException e) {
			LOGGER.error("ERRO AO CONECTAR NA URL GOOGLE-->{}", e.getMessage());
			e.printStackTrace();
		}

		return partida;
	}

}
