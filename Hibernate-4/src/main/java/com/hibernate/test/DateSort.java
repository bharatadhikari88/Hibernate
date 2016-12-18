package com.hibernate.test;

import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;

public class DateSort {

	public static void main(String[] args) {
		/** format yyyyddmmhhMMss **/
		String[] dates = { "20162107152332", "20162106152332",
				"20162107212332", "20162107154332", "20162105152332",
				"20162106152332" };
		TreeMap<Date, String> fileNames = new TreeMap<>();
		Calendar fileDate;
		Calendar today = Calendar.getInstance();

		for (String date : dates) {
			fileDate = convertStringToData(date);
			if (fileDate.get(Calendar.YEAR) == today.get(Calendar.YEAR)
					&& fileDate.get(Calendar.MONTH) == today.get(Calendar.MONTH) + 1
					&& fileDate.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)){
				fileNames.put(fileDate.getTime(), "File_" + date);
			}
		}
		
		System.out.println("Today Files");
		System.out.println(fileNames);
		System.out.println("Latest File");
		System.out.println(fileNames.lastEntry());

	}

	@SuppressWarnings("deprecation")
	private static Calendar convertStringToData(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int day = Integer.parseInt(date.substring(4, 6));
		int month = Integer.parseInt(date.substring(6, 8));
		int hour = Integer.parseInt(date.substring(8, 10));
		int min = Integer.parseInt(date.substring(10, 12));
		int sec = Integer.parseInt(date.substring(12, 14));
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, min);
		c.set(Calendar.SECOND, sec);

		return c;
	}

}
