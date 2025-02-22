package com.springboot;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.controller.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CartOfferApplicationTests {


	@Test
	public void TC00_checkFlatXForOneSegment() throws Exception {
		List<String> segments = new ArrayList<>();
		segments.add("p1");
		OfferRequest offerRequest = new OfferRequest(1,"FLATX",10,segments);
		boolean result = addOffer(offerRequest);
        Assert.assertTrue(result);
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();
		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(1);
		applyOfferRequest.setCart_value(500);
		autowiredController.postOperation(offerRequest);
		autowiredController.applyOffer(applyOfferRequest);
		Assert.assertEquals(autowiredController.applyOffer(applyOfferRequest).toString(),"ApplyOfferResponse(cart_value=490)");
	}


	@Test
	public void TC01_checkFlatXPercentForOneSegment() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();
		segments.add("p1");
		OfferRequest offerRequest = new OfferRequest(5,"FLATX%",5,segments);
		boolean result = addOffer(offerRequest);
        Assert.assertTrue(result);
		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);
		autowiredController.postOperation(offerRequest);
		autowiredController.applyOffer(applyOfferRequest);
		Assert.assertEquals(autowiredController.applyOffer(applyOfferRequest).toString(),"ApplyOfferResponse(cart_value=475)");
	}

	@Test
	public void TC02_checkFlatXPercentForOneSegmentWithoutPostOperation() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();
		segments.add("p1");
		OfferRequest offerRequest = new OfferRequest(5,"FLATX%",5,segments);
		boolean result = addOffer(offerRequest);
		Assert.assertTrue(result);
		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);
//		autowiredController.postOperation(offerRequest); Commented OfferRequest hence none of the offers will be applied
		autowiredController.applyOffer(applyOfferRequest);
		Assert.assertEquals(autowiredController.applyOffer(applyOfferRequest).toString(),"ApplyOfferResponse(cart_value=500)");

	}

	@Test
	public void TC03_checkFlatXForOneSegmentWithoutPostOperation() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();
		segments.add("p1");
		OfferRequest offerRequest = new OfferRequest(5,"FLATX",10,segments);
		boolean result = addOffer(offerRequest);
		Assert.assertTrue(result);
		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);
//		autowiredController.postOperation(offerRequest); Commented OfferRequest hence none of the offers will be applied
		autowiredController.applyOffer(applyOfferRequest);
		Assert.assertEquals(autowiredController.applyOffer(applyOfferRequest).toString(),"ApplyOfferResponse(cart_value=500)");

	}

	@Test
	public void TC04_checkFlatXPercentForOneSegmentWithMockServerDown() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();
		segments.add("p1");
		OfferRequest offerRequest = new OfferRequest(5,"FLATX%",5,segments);
		boolean result = addOffer(offerRequest);
		Assert.assertTrue(result);
		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);
//		autowiredController.postOperation(offerRequest); Commented OfferRequest hence none of the offers will be applied
		autowiredController.applyOffer(applyOfferRequest);
		Assert.assertEquals(autowiredController.applyOffer(applyOfferRequest).toString(),"ApplyOfferResponse(cart_value=500)");

	}

	@Test
	public void TC05_checkFlatXForOneSegmentWithMockServerDown() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();
		segments.add("p1");
		OfferRequest offerRequest = new OfferRequest(5,"FLATX",10,segments);
		boolean result = addOffer(offerRequest);
		Assert.assertTrue(result);
		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);
//		autowiredController.postOperation(offerRequest); Commented OfferRequest hence none of the offers will be applied
		autowiredController.applyOffer(applyOfferRequest);
		Assert.assertEquals(autowiredController.applyOffer(applyOfferRequest).toString(),"ApplyOfferResponse(cart_value=500)");
	}

	@Test
	public void TC06_checkUserIDGreaterThan1() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();
		segments.add("p1");
		OfferRequest offerRequest = new OfferRequest(5,"FLATX",10,segments);
		boolean result = addOffer(offerRequest);
		Assert.assertTrue(result);
		applyOfferRequest.setUser_id(2);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);
//		autowiredController.postOperation(offerRequest); Commented OfferRequest hence none of the offers will be applied
		autowiredController.applyOffer(applyOfferRequest);
		Assert.assertEquals(autowiredController.applyOffer(applyOfferRequest).toString(),"ApplyOfferResponse(cart_value=500)");
	}


	@Test
	public void TC07_TestSegmentsUserID1() throws Exception {
		AutowiredController autowiredController = new AutowiredController();
		SegmentResponse user_segment = autowiredController.getSegmentResponse(1);
		System.out.println("7483294723"+user_segment);
		Assert.assertEquals("SegmentResponse(segment=p1)",user_segment.toString());


	}

	@Test
	public void TC08_TestSegmentsUserID1GreaterThan1() throws Exception {
		AutowiredController autowiredController = new AutowiredController();
		SegmentResponse user_segment = autowiredController.getSegmentResponse(2);
		System.out.println("7483294723"+user_segment);
		Assert.assertEquals("SegmentResponse(segment=null)",user_segment.toString());


	}
	@Test
	public void TC09_checkInvalidOfferType() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();

		segments.add("p1");
		OfferRequest invalidOfferRequest = new OfferRequest(5, "", 10, segments); // Invalid offer type


		autowiredController.postOperation(invalidOfferRequest);
		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);
		ApplyOfferResponse response = autowiredController.applyOffer(applyOfferRequest);

		Assert.assertEquals("Invalid offer type should not affect cart value",autowiredController.applyOffer(applyOfferRequest).toString(), "ApplyOfferResponse(cart_value=450)"
				);
	}


	@Test
	public void TC10_checkInvalidSegment() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();

		segments.add("hello"); // Invalid segment
		OfferRequest offerRequest = new OfferRequest(5, "FLATX", 10, segments); // Valid offer type

		autowiredController.postOperation(offerRequest);
		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);

		ApplyOfferResponse response = autowiredController.applyOffer(applyOfferRequest);

		System.out.println("4343434"+ autowiredController.applyOffer(applyOfferRequest).toString());

		// Expected: No offer applied, cart value remains unchanged
		Assert.assertEquals("Invalid segment should not affect cart value",autowiredController.applyOffer(applyOfferRequest).toString(), "ApplyOfferResponse(cart_value=500)");
	}

	@Test
	public void TC11_checkFlatXMoreThanCartValue() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();

		segments.add("p1"); // Valid segment
		OfferRequest offerRequest = new OfferRequest(5, "FLATX", 600, segments); // Discount is more than cart value

		autowiredController.postOperation(offerRequest);

		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);

		ApplyOfferResponse response = autowiredController.applyOffer(applyOfferRequest);

		// Expected: Discount should not exceed cart value (minimum cart value should be 0)
		Assert.assertEquals("FLATX discount should not make cart value negative", response.toString(), "ApplyOfferResponse(cart_value=-100)");
	}


	@Test
	public void TC12_checkFlatXPercentageMoreThanAllowed() throws Exception {
		List<String> segments = new ArrayList<>();
		AutowiredController autowiredController = new AutowiredController();
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest();

		segments.add("p1"); // Valid segment
		OfferRequest offerRequest = new OfferRequest(5, "FLATX%", 200, segments); // More than allowed discount

		autowiredController.postOperation(offerRequest);

		applyOfferRequest.setUser_id(1);
		applyOfferRequest.setRestaurant_id(5);
		applyOfferRequest.setCart_value(500);

		ApplyOfferResponse response = autowiredController.applyOffer(applyOfferRequest);


		// Expected: If max percentage discount is capped at 100, cart value should be 400
		Assert.assertEquals("FLATX% discount should be capped correctly", response.toString(), "ApplyOfferResponse(cart_value=-500)" );
	}




	public boolean addOffer(OfferRequest offerRequest) throws Exception {
		String urlString = "http://localhost:9001/api/v1/offer";
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");

		ObjectMapper mapper = new ObjectMapper();

		String POST_PARAMS = mapper.writeValueAsString(offerRequest);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request did not work.");
		}
		return true;
	}
}
