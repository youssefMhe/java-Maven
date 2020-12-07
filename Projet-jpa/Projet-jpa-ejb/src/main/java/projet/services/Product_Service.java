package projet.services;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import projet.entity.*;
import projet.interfaces.Product_Interface;






@Stateless
@LocalBean
public class Product_Service implements Product_Interface {
	@PersistenceContext(unitName = "jee-ejb") 
	EntityManager em;
	/**
	 * Default constructor. 
	 */
	public Product_Service() {

	}



	@Override
	public List<Product> getProduct() {
		return (List<Product>) em.createQuery(" select c from Product c ",Product.class).getResultList();
	}

	@Override
	public void addProduct(Product p) {
		em.persist(p);

	}

	@Override
	public void deleteProductById(int id) {
		Product c = em.find(Product.class, id);
		em.remove(c);


	}



	@Override
	public void updateProduct(Product p) {
		Product ProducttoUpdade = em.find(Product.class, p.getId());


		ProducttoUpdade.setCode_AB(p.getCode_AB());
		ProducttoUpdade.setDescription(p.getDescription());

		ProducttoUpdade.setName(p.getName());
		ProducttoUpdade.setPicture(p.getPicture());

		ProducttoUpdade.setPrice(p.getPrice());
		ProducttoUpdade.setQuantity(p.getQuantity());

		ProducttoUpdade.setType(p.getType());
		ProducttoUpdade.setTva(p.getTva());


	}



	@Override
	public void createfileExel() {

		
		
		 String[] columns = {"Code du produit", "nom du produit", "Quantite du produit "};

	

		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Cricketer Data");

		//This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		List<Product> p =  em.createQuery(" select c from Product c ",Product.class).getResultList() ;
		
		for (Product elems : p)
		{
			data.put(  Integer.toString(elems.getId()) , new Object[] { elems.getCode_AB(), elems.getName(), elems.getQuantity()});
			
			} 
		//Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 1;

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.GREEN.getIndex());
		
		// Create a Font for styling header cells
				Font headerFont2 = workbook.createFont();
				headerFont2.setBold(true);
				headerFont2.setFontHeightInPoints((short) 14);
				headerFont2.setColor(IndexedColors.RED1.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Header Row
		Row headerRow = sheet.createRow(0);

		// Create cells
		for(int i = 0; i < columns.length; i++) {
		Cell cell = headerRow.createCell(i);
		cell.setCellValue(columns[i]);
		cell.setCellStyle(headerCellStyle);
		}

		for (String key : keyset)
		{
		Row row = sheet.createRow(rownum++);
		Object [] objArr = data.get(key);
		int cellnum = 0;
		for (Object obj : objArr)
		{
		Cell cell = row.createCell(cellnum++);
		if(obj instanceof String)
		cell.setCellValue((String)obj);
		else if(obj instanceof Integer)
		{cell.setCellValue((Integer)obj);

		}
		}
		}
		
		//teste la valeur de quantite < 100 

		FormulaEvaluator formulaEvaluator = 
				workbook.getCreationHelper().createFormulaEvaluator();

		for (Row ligne : sheet) {//parcourir les lignes
			for (Cell cell1 : ligne) {//parcourir les colonnes
				//évaluer le type de la cellule

				switch (formulaEvaluator.evaluateInCell(cell1).getCellType())
				{
				case NUMERIC:
					if ( cell1.getNumericCellValue()  < 100) 
					{


						/*création d'un nouveau style*/
						CellStyle cs = workbook.createCellStyle();
						cs.setFont(headerFont2);
						//appliquer le style à la cellule 3(D1)
						ligne.getCell(2).setCellStyle(cs);
					}
					break;

				}
			}
			
		}
		
		
		
		try
		{
		//Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\User\\Desktop\\fr\\fileProduct.xlsx"));
		workbook.write(out);
		out.close();
		Toolkit.getDefaultToolkit().beep();
		java.awt.Toolkit.getDefaultToolkit().beep();
		
	
		//AudioClip clip = Applet.newAudioClip(getClass().getResource("C:\\Users\\User\\Desktop\\fr\\ab.wav"));
       
        
        AudioClip  clip = Applet.newAudioClip(getClass().getClassLoader().getResource("C:\\Users\\User\\Desktop\\fr\\ab.wav"));
        clip.play();
    
		System.out.println("****File written successfully*****");
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}


		}



		


	


	
	
	
	
	
	
	

	@Override
	public void updateProduct_From_Exel() {
		List<Product> p = em.createQuery(" select c from Product c ",Product.class).getResultList();
		
		
		// TODO Auto-generated method stub
		
		String fileLocation = "C:\\Users\\User\\Desktop\\fr\\fileProduct.xlsx" ;
		int i = 0 ;
		
		
		       FileInputStream fichier = null;
			try {
				fichier = new FileInputStream(new File(fileLocation));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		       //créer une instance workbook qui fait référence au fichier xlsx 
		       XSSFWorkbook wb = null;
			try {
				wb = new XSSFWorkbook(fichier);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		       XSSFSheet sheet = wb.getSheetAt(0);
		       
		  
		       FormulaEvaluator formulaEvaluator = 
		                     wb.getCreationHelper().createFormulaEvaluator();
		  
		      for (Row ligne : sheet) {//parcourir les lignes
		         for (Cell cell : ligne) {//parcourir les colonnes
		           //évaluer le type de la cellule
		           switch (formulaEvaluator.evaluateInCell(cell).getCellType())
		           {
		                 case NUMERIC:
		                	 
		                	 for(i=1; i<=p.size();i++)
		                	 {
		                	 if ( cell.getNumericCellValue()  > 0) 
								{
		                		 XSSFRow row = sheet.getRow(i);
		                		
                            //     p.get(i).setQuantity((int)ligne.getCell(2,i).getNumericCellValue());
		                		 
                              p.get(i-1).setQuantity((int)row.getCell(2).getNumericCellValue());
			                	 
									
								}
		                	 }
		                	 
								break;
		                 
		           }
		           }
		      }
		      AudioClip  clip = Applet.newAudioClip(getClass().getClassLoader().getResource("C:\\Users\\User\\Desktop\\fr\\aba.wav"));
		        clip.play();
		      }



	@Override
	public Product getProductbyid(int id) {
		Product p = em.find(Product.class,id);
		return p;
	}
		       
		       
		    
		       
		





}
