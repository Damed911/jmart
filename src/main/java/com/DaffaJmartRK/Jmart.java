package com.DaffaJmartRK;

import com.DaffaJmartRK.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class utama dari program back-end Jmart
 * @author M. Daffa Ajiputra
 * @version Final
 */
@SpringBootApplication
class Jmart
{
	/**
	 * Program utama dari Jmart
	 * @param args	parameter dari program utama
	 */
    public static void main(String[] args) {
    	JsonDBEngine.Run(Jmart.class);
    	SpringApplication.run(Jmart.class, args);
    	Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
    
}
