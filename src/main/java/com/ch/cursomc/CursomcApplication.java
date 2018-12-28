package com.ch.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ch.cursomc.domain.Adresse;
import com.ch.cursomc.domain.Category;
import com.ch.cursomc.domain.Client;
import com.ch.cursomc.domain.Product;
import com.ch.cursomc.domain.Province;
import com.ch.cursomc.domain.Ville;
import com.ch.cursomc.domain.enums.TypeClient;
import com.ch.cursomc.repositories.AdresseRepository;
import com.ch.cursomc.repositories.CategoryRepository;
import com.ch.cursomc.repositories.ClientRepository;
import com.ch.cursomc.repositories.ProductRepository;
import com.ch.cursomc.repositories.ProvinceRepository;
import com.ch.cursomc.repositories.VilleRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
    private	CategoryRepository categoryRepository;

	@Autowired
    private	ProductRepository productRepository;
	@Autowired
    private	ProvinceRepository provinceRepository;
	@Autowired
    private	VilleRepository villeRepository;
	@Autowired
    private	ClientRepository clientRepository;
	@Autowired
    private	AdresseRepository adresseRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}


	
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informatique");
		Category cat2 = new Category(null, "Bureau 2");
		
		Product p1 = new Product(null, "Ordinateur", 2000.00);
		Product p2 = new Product(null, "Printer", 100.00);
		Product p3 = new Product(null, "souris", 30.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		System.out.println(cat1);
		System.out.println(cat2.getProducts().get(0).getNom());
		
		Province prov1 = new Province(null, "Quebec");
		Province prov2 = new Province(null, "Ontario");
		Ville ville1 = new Ville(null, "Montreal", prov1);
		Ville ville2 = new Ville(null, "Longueuil", prov1);
		Ville ville3 = new Ville(null, "Toronto", prov2);
		
		prov1.getVilles().addAll(Arrays.asList(ville1, ville2));
		prov2.getVilles().addAll(Arrays.asList(ville3));
		
		provinceRepository.saveAll(Arrays.asList(prov1, prov2));
		villeRepository.saveAll(Arrays.asList(ville1, ville2, ville3));
		
		Client cli1 = new Client(null, "Carlos Lopes", "correioch@gmail.com", "373738393", TypeClient.Personne);

		Adresse adresse1 = new Adresse(null, "Rue de Boulogne", "2510", "210", "Viux Longueuil", "J4L 4C3", cli1, ville2);
		
		Adresse adresse2 = new Adresse(null, "boulevard Saint joseph", "2151", "3", "Plateau", "h2h 1e9", cli1, ville1);
		
		cli1.getTelephones().addAll(Arrays.asList("4389242680", "4389242681"));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		adresseRepository.saveAll(Arrays.asList(adresse1, adresse2));	
		
	}

}

