package javaBasic;

import java.util.Iterator;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_For_ForEach {
Scanner scanner = new Scanner(System.in);

  @Test
  public void For () {
  String[] cityName = {"HaNoi", "HaiPhong", "HCM"};
  
  for (int i = 0; i < cityName.length; i++) {
	System.out.println(cityName[i]);
}

  }
  @Test
  public void Bien_Gia () {
  String[] cityName = {"HaNoi", "HaiPhong", "HCM"};
  //Dung khi chay ra dieu kien thoa man
  for (String city:cityName) {
	System.out.println(city);
   }

  }
  @Test
  public void For_IF () {
	  String[] cityName = {"HaNoi", "HaiPhong", "HCM", "DN"};
	  
	  for (int i = 0; i < cityName.length; i++) {
		  if(cityName[i].equals("HCM"))
		System.out.println(cityName[i]); 
   }

  }
}

