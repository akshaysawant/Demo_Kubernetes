package com.k8s.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class CodeStateBEApp {

    private static ConfigurableApplicationContext ctx = null;
    private static final Logger LOG = LoggerFactory.getLogger(CodeStateBEApp.class);

    final static String stateToCode = "Alabama:Alabama has Zipcode starting with 35801."  +
    " Alabama is a state in the southeastern region of the United States. It is bordered" +
    "by Tennessee to the north, Georgia to the east, Florida and the Gulf of Mexico to "  +
    "the south, and Mississippi to the west. Alabama is the 30th largest by area and "    +
    "the 24th-most populous of the U.S. states. With a total of 1,500 miles (2,400 km) "  +
    "of inland waterways, Alabama has among the most of any state.\n"

                                     + "Alaska:Alaska has Zipcode starting with 99501."     +
    "On March 30, 1867, the United States purchased Alaska from the Russian Empire for "    +
    "7.2 million U.S. dollars, or approximately two cents per acre ($4.74/km2). The area"   +
    " went through several administrative changes before becoming organized as a territory" +
    " on May 11, 1912. It was admitted as the 49th state of the U.S. on January 3, 1959.\n"

                                     + "Arizona:Arizona has Zipcode starting with 85001."   +
    "Arizona ; Navajo: Hoozdo Hahoodzo is a state in the southwestern region of the United" +
    " States. It is also part of the Western and the Mountain states. It is the sixth "     +
    "largest and the 14th most populous of the 50 states. Its capital and largest city is"  +
    " Phoenix. Arizona shares the Four Corners region with Utah, Colorado, and New Mexico;" +
    " its other neighboring states are Nevada and California to the west and the Mexican "  +
    "states of Sonora and Baja California to the south and southwest.\n"

                                     + "Arkansas:Arkansas has Zipcode starting with 72201." +
    "Arkansas is the 29th largest by area and the 33rd most populous of the 50 United "     +
    "States. The capital and most populous city is Little Rock, located in the central "    +
    "portion of the state, a hub for transportation, business, culture, and government. "   +
    "The northwestern corner of the state, such as the Fayetteville–Springdale–Rogers "     +
    "Metropolitan Area and Fort Smith metropolitan area, is a population, education, and"   +
    " economic center. The largest city in the state's eastern part is Jonesboro. The "     +
    "largest city in the state's southeastern part is Pine Bluff.\n"

                                     + "California:California has Zipcode starting with 94203." +
    "California is a state in the Pacific Region of the United States. With 39.6 million "      +
    "residents across a total area of about 163,696 square miles (423,970 km2), California"     +
    " is the most populous U.S. state and the third-largest by area. The state capital is"      +
    " Sacramento. The Greater Los Angeles Area and the San Francisco Bay Area are the "         +
    "nation's second- and fifth-most populous urban regions, with 18.7 million and 9.7 "        +
    "million residents respectively.\n"

                                     + "Colorado:Colorado has Zipcode starting with 80201." +
    "Colorado is bordered by Wyoming to the north, Nebraska to the northeast, Kansas to "   +
    "the east, Oklahoma to the southeast, New Mexico to the south, Utah to the west, and "  +
    "touches Arizona to the southwest at the Four Corners. Colorado is noted for its vivid" +
    " landscape of mountains, forests, high plains, mesas, canyons, plateaus, rivers and "  +
    "desert lands. Colorado is part of the western and southwestern United States, and is"  +
    " one of the Mountain States.\n"

                                     + "Conneticut:Conneticut has Zipcode starting with 06101." +
    "Connecticut is the southernmost state in the New England region of the northeastern "      +
    "United States. As of the 2010 Census, it has the highest per-capita income, Human "        +
    "Development Index (0.962), and median household income in the United States. It is "       +
    "bordered by Rhode Island to the east, Massachusetts to the north, New York to the west,"   +
    " and Long Island Sound to the south. Its capital is Hartford and its most populous "       +
    "city is Bridgeport.\n";

    final static String codeToState = "35801:Zipcode 35801 belongs to Alabama."  +
    " Alabama is a state in the southeastern region of the United States. It is bordered" +
    "by Tennessee to the north, Georgia to the east, Florida and the Gulf of Mexico to "  +
    "the south, and Mississippi to the west. Alabama is the 30th largest by area and "    +
    "the 24th-most populous of the U.S. states. With a total of 1,500 miles (2,400 km) "  +
    "of inland waterways, Alabama has among the most of any state.\n"

                                      + "99501:Zipcode 99501 belongs to Alaska." +
    "On March 30, 1867, the United States purchased Alaska from the Russian Empire for "    +
    "7.2 million U.S. dollars, or approximately two cents per acre ($4.74/km2). The area"   +
    " went through several administrative changes before becoming organized as a territory" +
    " on May 11, 1912. It was admitted as the 49th state of the U.S. on January 3, 1959.\n"

                                            + "85001:Zipcode 85001 belongs to Arizona." +
    "Arizona ; Navajo: Hoozdo Hahoodzo is a state in the southwestern region of the United" +
    " States. It is also part of the Western and the Mountain states. It is the sixth "     +
    "largest and the 14th most populous of the 50 states. Its capital and largest city is"  +
    " Phoenix. Arizona shares the Four Corners region with Utah, Colorado, and New Mexico;" +
    " its other neighboring states are Nevada and California to the west and the Mexican "  +
    "states of Sonora and Baja California to the south and southwest.\n"

                                            + "72201:Zipcode 72201 belongs to Arkansas." +
    "Arkansas is the 29th largest by area and the 33rd most populous of the 50 United "     +
    "States. The capital and most populous city is Little Rock, located in the central "    +
    "portion of the state, a hub for transportation, business, culture, and government. "   +
    "The northwestern corner of the state, such as the Fayetteville–Springdale–Rogers "     +
    "Metropolitan Area and Fort Smith metropolitan area, is a population, education, and"   +
    " economic center. The largest city in the state's eastern part is Jonesboro. The "     +
    "largest city in the state's southeastern part is Pine Bluff.\n"

                                            + "94203:Zipcode 94203 belongs to California." +
    "California is a state in the Pacific Region of the United States. With 39.6 million "      +
    "residents across a total area of about 163,696 square miles (423,970 km2), California"     +
    " is the most populous U.S. state and the third-largest by area. The state capital is"      +
    " Sacramento. The Greater Los Angeles Area and the San Francisco Bay Area are the "         +
    "nation's second- and fifth-most populous urban regions, with 18.7 million and 9.7 "        +
    "million residents respectively.\n"

                                            + "80201:Zipcode 80201 belongs to Colorado." +
    "Colorado is bordered by Wyoming to the north, Nebraska to the northeast, Kansas to "   +
    "the east, Oklahoma to the southeast, New Mexico to the south, Utah to the west, and "  +
    "touches Arizona to the southwest at the Four Corners. Colorado is noted for its vivid" +
    " landscape of mountains, forests, high plains, mesas, canyons, plateaus, rivers and "  +
    "desert lands. Colorado is part of the western and southwestern United States, and is"  +
    " one of the Mountain States.\n"

                                            + "06101:Zipcode 06101 belongs to Conneticut." +
    "Connecticut is the southernmost state in the New England region of the northeastern "      +
    "United States. As of the 2010 Census, it has the highest per-capita income, Human "        +
    "Development Index (0.962), and median household income in the United States. It is "       +
    "bordered by Rhode Island to the east, Massachusetts to the north, New York to the west,"   +
    " and Long Island Sound to the south. Its capital is Hartford and its most populous "       +
    "city is Bridgeport.\n";

	public static void main(String[] args) {
        ctx = SpringApplication.run(CodeStateBEApp.class, args);
	}

	public static String requestProcessedData(int urlId){

	    String serverUrl = null;

	    if (urlId == 1){
	        serverUrl = codeToState;
        } else if (urlId == 2) {
            serverUrl = stateToCode;
        } else {
            serverUrl = "ERROR";
        }

        LOG.info(serverUrl);
	    return serverUrl;
    }

	@GetMapping("/")
    public static String Hello() {
        LOG.info("Hello I'm Data Reader");
	    return "Hello I'm Data Reader";
    }

    @GetMapping("/readDataForCode")
    public static String requestCodeData() {
        LOG.info("Serving readDataForCode");
	    return requestProcessedData(1);
    }

    @GetMapping("/requestDataForState")
    public static String requestStateData(){
        LOG.info("Serving requestDataForState");
	    return requestProcessedData(2);
    }

    @GetMapping("/exit")
    public static void exitApp() {
	    LOG.info("Exiting Springboot App.");
        ctx.close();
    }

}
