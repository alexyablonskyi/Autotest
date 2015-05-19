package netsuite.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.util.StringUtils;
import com.google.gson.Gson;

import org.json.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// TODO: Auto-generated Javadoc
/**
 * The Class RunCalc.
 */
public class JSON {

	/** The working dir. */
	public static String workingDir = System.getProperty("user.dir");

	/** The user agent. */
	private final String USER_AGENT = "Mozilla/5.0";

	/** The file name. */
	public String fileName = workingDir+"/Distribution.xlsx";

	/** The hms video id. */
	HashMap<String,Integer> hmsVideoId=new HashMap<String,Integer>();

	/** The Video id per mashup. */
	HashMap<String,Integer> VideoIdPerMashup =new HashMap<String,Integer>();

	/** The Video id neighbor mashup. */
	HashMap<String,Integer> VideoIdNeighborMashup =new HashMap<String,Integer>();

	/** The author id. */
	HashMap<String,Integer> authorId=new HashMap<String,Integer>();

	/** The length id. */
	HashMap<String,Integer> lengthId=new HashMap<String,Integer>();

	/** The school id. */
	HashMap<String,Integer> schoolId=new HashMap<String,Integer>();

	/** The data results. */
	Map<String, Object[]> dataResults = new TreeMap<String, Object[]>();

	/** The quantity video mashup. */
	int quantityVideoMashup;

	/** The count neighbor mashup. */
	int countNeighborMashup = 0;

	/** The len mashup. */
	int lenMashup;

	/** The repeat video. */
	ArrayList<String> repeatVideo = new ArrayList<String>();


	/** The repeted video mashup. */
	boolean repetedVideoMashup = false;

	/** The repeted neighbor video mashup. */
	boolean repetedNeighborVideoMashup = false;

	int digit = 4;
	/**
	 * Test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void test() throws Exception{

	    Gson gson = new Gson();
	    String json = gson.toJson("help layover");
	    System.out.println(json);

		String url = "https://forms.sandbox.netsuite.com/app/site/hosting/scriptlet.nl?script=282&deploy=1&compid=3363929&h=288eeb5121d7dd217ad5";

		    URL obj = new URL(url);
		    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		    // optional default is GET
			con.setRequestMethod("GET");

			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response);
			
			String jsonString = response.toString();
			JSONObject jsonObj = new JSONObject();
			
			jsonString.getBytes(jsonString);
			
			/*
			String path = "C:/Users/oyablonskyi/Documents/GitHub/Autotest/NetsuiteSite/test-output/tests.xls";

            ObjectOutputStream outputStream = null;
        try{
			outputStream = new ObjectOutputStream(new FileOutputStream(path));
            System.out.println("Start Writings");
            String jsonString = response.toString();
                outputStream.writeObject(jsonString);
                outputStream.flush();
                    outputStream.close();
          }catch (Exception e){
          System.err.println("Error: " + e);
          }
			
			
			
			*/
			
			
			
			
			
			/*
			
			
			Array[] test = new Array
					[{"title":"Can I change or add items to my order if I forgot something?","description":"Please contact a Work Stylist at <a href=\"mailto:workstylist@poppin.com\">workstylist@poppin.com</a> or (888) 676-7746 right away.  We ship very quickly but if your order hasn't been shipped yet we can add the missing items for you."},
			 {"title":"Can I set up a reoccurring order?","description":"Our site currently doesn't support reoccurring orders."},{"title":"How do I see my order history?","description":"Log on to Poppin.com with your username and password and click on <a href=\"https://secure.poppin.com/app/center/nlvisitor.nl/sc.6/.f\">My Account</a>. From there you'll be able to see your order history."},
			 {"title":"Can I place an order with a purchase order?","description":"Yes. Contact <a <a href=\"mailto:sales@poppin.com\">sales@poppin.com</a> or call 888-676-7746 and we'll be happy to take care of you."},{"title":"Iâ€™m tax-exempt. How do I indicate this in checkout?","description":"Contact a Work Stylist at <a href=\"mailto:workstylist@poppin.com\">workstylist@poppin.com</a> or call 888-676-7746."},
			 {"title":"Do you sell wholesale?","description":"Yes we do! Feel free to email us at <a href=\"mailto:howdy@poppin.com\">howdy@poppin.com</a>."},{"title":"Can I use an international credit card?","description":"At this time Poppin only accepts credit cards with United States billing addresses. &nbsp;If you're trying to place an order with a foreign bank we do accept PayPal."},
			 {"title":"Can I place my order over the phone?","description":"Yes you can! Call a Work Stylist at 888-676-7746 and they'll gladly assist you."},
			 {"title":"Can I cancel my order?","description":"Please contact a Work Stylist right away at <a href=\"mailto:workstylist@poppin.com\">workstylist@poppin.com</a> or (888) 676-7746; as long as your order hasn't been shipped, they can cancel your order."},
			 {"title":"How do I know something is in stock?","description":"If you see a product listed on Poppin.com, we have it in stock. Easy as that!"},{"title":"How do I know if you received my order?","description":"Once you place your order with Poppin, you'll receive an email confirming that we have your order. If you haven't received this email, fear not. It's probably sitting in your spam folder. If it's not in your spam folder and you don't receive it within 1 hour after placing your order, contact a Work Stylist at <a href=\"mailto:workstylist@poppin.com\">workstylist@poppin.com</a> or (888) 676-7746 to confirm."},
			 {"title":"Who do I contact about corporate orders?","description":"For corporate orders contact <a <a href=\"mailto:sales@poppin.com\">sales@poppin.com</a> or call 888-676-7746."}
			 ];
*/
			
			
	}
	





















}
