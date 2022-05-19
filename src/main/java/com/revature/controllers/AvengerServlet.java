package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Avenger;
import com.revature.models.Home;
import com.revature.services.AvengerService;
import com.revature.services.HomeService;

public class AvengerServlet extends HttpServlet {

	private HomeService homeService = new HomeService();
	private AvengerService avengerService = new AvengerService();
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();

		System.out.println(uri);

		String[] urlSections = uri.split("/");

		if (urlSections.length == 3) {
			List<Avenger> list = avengerService.findAll();

			String json = objectMapper.writeValueAsString(list);

			PrintWriter print = resp.getWriter();
			print.print(json);
			resp.setStatus(200);
			resp.setContentType("application/json");
		} else if (urlSections.length == 4) {
			String spacedName = urlSections[3].replace("%20", " ");
			Avenger avenger = avengerService.findById(Integer.parseInt(spacedName));
			String json = objectMapper.writeValueAsString(avenger);

			PrintWriter print = resp.getWriter();
			print.print(json);
			resp.setStatus(200);
			resp.setContentType("application/json");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		BufferedReader reader = req.getReader();

		StringBuilder stringBuilder = new StringBuilder();

		String line = reader.readLine(); // Gets first line from buffered reader

		while (line != null) {
			stringBuilder.append(line);
			line = reader.readLine(); // Gets the next line, returns null at end of body.
		}

		String body = new String(stringBuilder);

		Avenger avenger = objectMapper.readValue(body, Avenger.class);

		if (avengerService.addAvenger(avenger)) {
			resp.setStatus(201);
		} else {
			resp.setStatus(406);
		}
	}

}
