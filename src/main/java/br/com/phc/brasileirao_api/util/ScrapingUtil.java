package br.com.phc.brasileirao_api.util;

import br.com.phc.brasileirao_api.dto.PartidaGoogleDTO;

public class ScrapingUtil {

	private static final String BASE_URL_GOOGLE = "https://www.google.com.br/seache?q=";
	private static final String COMPLEMNTO_URL_GOOGLE = "&hl=pt-BR";

	public static void main(String[] args) {
		
PartidaGoogleDTO partida = new PartidaGoogleDTO();	
     partida.getGolsEquipeCasa();
	}

}
