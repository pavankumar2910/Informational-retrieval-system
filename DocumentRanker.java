package ass2test;



import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Collator;
import java.util.Map.Entry;

public class ReadInputFiles {

	private int counter = 0;
	private static final String DOC_END_TAG = "</DOCNO>";
	private static final String DOC_START_TAG = "<DOCNO>";
	private static final String TEXT_END_TAG = "</TEXT>";

	private static final String TEXT_START_TAG = "<TEXT>";


	// private ReadInputDatatype readInputDatatype;
	private Set<String> content = new HashSet<>();
	private static List<String> stopList = new ArrayList<>();
	private List<String> test = new ArrayList<>();
	private List<String> test2 = new ArrayList<>();
	private List<String> test3 = new ArrayList<>();
	private List<String> test4 = new ArrayList<>();

	private static String line = null;
	private int index = 0;
	private static HashMap<String, Integer> wordDict = new HashMap<>();
	private static HashMap< String, Integer> fileDict = new HashMap<>();
	static HashMap<String, Map<String, Integer>> findex = new HashMap<>();
	static HashMap<String, Map<String, Integer>> iindex = new HashMap<>();
	private static Scanner input;
	static HashMap<String, Double> cosine = new HashMap<>();
//	private static Scanner input11;
	// Test
	public static void main(String args[]) {
		System.out.println("Started");
		ReadInputFiles readInputFiles = new ReadInputFiles();
	String l="null",l1="null";
		readInputFiles.loadData1();

		BufferedReader bufferedReader = null;
		
	
		
		
	/*	 Scanner input = new Scanner(System.in);
		   System.out.print("enter the word ");
		    String word = input.next();
	giveout(word);
		input.close();*/
		
		
		
		
		
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("./vsm_output.txt"));
			
			
		//	readInputFiles.writeContent1(readInputFiles.cosine, writer);

			
//readInputFiles.writeContent2(readInputFiles.iindex, writer);

			int t=352;
		
		//String filesList1 = loadFiles("./src/topics.txt");
		bufferedReader = new BufferedReader(new FileReader("./src/topics.txt"));
		while ((line = bufferedReader.readLine()) != null) {
			//System.out.println(line);
			if (line.contains("<title>")) {
				l= line;
				l=l.replace("<title>","");
						//.substring(line.indexOf("<title>") + "<title>".length(),	line.indexOf("chunnel"));
			//	System.out.println(l);
				
			iftdf(l,writer,t);
			if(t==354)
			{
				t=359;
			}
			else{
			t=t+1;
			}
			}
		}
		writer.flush();
		writer.close();
		}
		 catch (Exception e) {
			// TODO: handle exception
		}
				
	/*f (line.contains("<title>")) {
			while (!(l = bufferedReader.readLine()).contains("<desc>")) {
				l1=l1.concat(l);
				System.out.println(l1);
			}
		}*/
			
		
		
		
		System.out.println("Completed");
	/*	BufferedWriter writer = null;
		try {
		
		writer = new BufferedWriter(new FileWriter("./parser_output.txt"));
			
		
			readInputFiles.writeContent1(readInputFiles.cosine, writer);

			
//readInputFiles.writeContent2(readInputFiles.iindex, writer);


		writer.flush();
			writer.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		

	}
	
	
	public static void iftdf(String s12, BufferedWriter writer , int t)
	{
		
		/* HashMap<String, Map<String, Float>> tf = new HashMap<>();
	//	tf=findex;
		Map<String,Float> temp= new HashMap<>();
		for (Map.Entry<String,Map<String, Integer>> e : findex.entrySet()) {
			temp.clear();
			String abc=	e.getKey();
					Map<String, Integer> tok = e.getValue();
				 for (Map.Entry<String, Integer> entry : tok.entrySet()) {
				        String key = entry.getKey();
				        Integer value =entry.getValue();
				        temp.put(key,(float)value/tok.size());
				       // writer.write(" " +wordDict.get(key) + " :" + value +"  ");
				     //   writer.write(" " +key + " :" + (float)value/tok.size() +"  ");

				 }
				 tf.put(abc, temp);
				// temp.clear();
				
				//	writer.newLine();
				
				
					}
		 for (Map.Entry<String,Map<String, Float>> e1 : tf.entrySet()) {
				String abcd=	e1.getKey();
					e1.getValue();
					//writer.write("    " + fileDict.get(abc) );
					System.out.println("    " + abcd );
					
					Map<String, Float> tok1 = e1.getValue();
					 for (Map.Entry<String, Float> entry1 : tok1.entrySet()) {
					        String key1 = entry1.getKey();
					        Float value1 = entry1.getValue();
					       // writer.write(" " +wordDict.get(key) + " :" + value +"  ");
					        System.out.println(" " +key1 + " :" + value1 +"  ");

					 }
						
					
					
						}*/
		/* Scanner input11 = new Scanner(System.in);
		  System.out.println("enter the sentance");
		 
		
	String inp = input11.nextLine();
		input11.close();
		List<String> inpp = new ArrayList<String>(Arrays.asList(inp.split(",")));
		List<String> word2=tokenizeContent(inpp);*/
		
		Map<String, Float> idf= new HashMap<>();
	
		for (Map.Entry<String,Map<String, Integer>> e : iindex.entrySet()) {
			String abc=	e.getKey();
				e.getValue();
				
				
				Map<String, Integer> tok = e.getValue();
		
				 for (Map.Entry<String, Integer> entry : tok.entrySet()) {
				        String key = entry.getKey();
				        Integer value = entry.getValue();
				    // System.out.println(key+"   "+value+"   "+tok.size()+"    "+abc);  
				        idf.put(abc,(float)(Math.log10(5368/tok.size())));
				      
				     //   System.out.println(Math.log10(2/tok.size())+" gdfhbfgng");
				 }
				 
					
					
					 }
		// for (Map.Entry<String, Float> entry1 : idf.entrySet()) {
		       
		    //  System.out.println(entry1.getKey()+"   "+entry1.getValue());
				
				//	}
		
			/*	String inp="pavan kumar";
		 //String inp =s12;
		 List<String> inpp = new ArrayList<String>(Arrays.asList(inp.split(",")));
			List<String> word2=tokenizeContent(inpp);
			 System.out.println(word2);
			 float x=0;
			 List<Float> v2= new ArrayList<>();
			 for (String s : word2) {
				 if(idf.get(s)==null)
				 {
					x=0;
				 }
				 else
				 {
				x=idf.get(s);	 
				 }
			//	System.out.println(idf.get(s));
				// v2.add(((float)1/word2.size())*x);
				  v2.add((float)x); 
			 }
		// System.out.println(v2);
		
		
		
		
			
			 List<Float> v1= new ArrayList<>();
				 for (Map.Entry<String,Map<String, Integer>> e : findex.entrySet()) {
					
					
					 String abc=	e.getKey();
							e.getValue();
							 for (String s : word2) {
							
							Map<String, Integer> tok = e.getValue();
							if(tok.containsKey(s))
							{
								//float b=((float)tok.get(s)/tok.size());
								float b=(float)tok.get(s);

								System.out.println(abc+"   "+tok.get(s)+"  "+tok.size() +"  "+b);
								v1.add(b*idf.get(s));	
								 
							}
							else
							{
							 v1.add((float) 0);      

							 }
								
							
							
								}
							 coss(abc,v1,v2);
							 System.out.println(v1);
								 System.out.println(v2);

							 v1.clear();
				 }*/
		
	//String inp=" Antarctica exploration";
		 String inp =s12;
		 List<String> inpp = new ArrayList<String>(Arrays.asList(inp.split(",")));
			List<String> word2=tokenizeContent(inpp);
		//	 System.out.println(word2);
			 float x=0 ;
			 int i=0;
			// int t1=352;
			 float scores[]=new float[findex.size()];
			 float length[]=new float[findex.size()];
			 List<Float> v2= new ArrayList<>();
		double ed=0,ee=0;
		
	/*	Map<String, Integer> map = new HashMap<>();
	    for (String w : word2) {
	        Integer n = map.get(w);
	        n = (n == null) ? 1 : ++n;
	        map.put(w, n);
	    }*/
				 for (Map.Entry<String,Map<String, Integer>> e : findex.entrySet()) {
						
						
					 String abc=	e.getKey();
					// System.out.println(i+"  "+abc);
							e.getValue();
							Map<String, Integer> tok = e.getValue();
						
							
							for (String s : word2) {
						
							if(tok.containsKey(s))
							{
								 if(idf.get(s)==null)
								 {
									x=0;
								 }
								 else
								 {
								x=idf.get(s);
								
								 }
								 scores[i]+=x*tok.get(s)*x;
								 ee+=Math.pow(idf.get(s),2);
								//	System.out.println(i+"     "+abc +"  "+scores[i]+"  "+tok.get(s)+" "+x);	
								
								//scores[i]+=idf.get(s)*tok.get(s)*idf.get(s);
							}
								
							
							
								//System.out.println(i+"  "+abc);
							 }
							
							 double ed1=0;
							 for (Map.Entry<String, Integer> entry : tok.entrySet()) {
							//	 System.out.println(entry.getKey()+"     "+entry.getValue()+" frequency");
								 String s3; 
								 s3=entry.getKey();
								ed1+=Math.pow(idf.get(s3)*tok.get(s3),2.0);
								 ed += (double)Math.pow(entry.getValue(),2.0);
								//	System.out.println(ed);

							 }
							 
					//	double s1=scores[i]/tok.size();
							//	System.out.println(s1);
							// System.out.println(ed+" drhgcfyk");
							 ed=Math.sqrt(ed);
							ed1=Math.sqrt(ed1);
						//	 System.out.println(ed);
							double s1=scores[i]/(ed1*Math.sqrt(ee));
							ee=0;
						//	double s1=scores[i]/(ed);

							ed=0;
						//	 ed1=0;
								i++;
								if(s1>0)
							{
								 cosine.put(abc,s1);
								}
				 }
								//float b=(float)tok.get(s);

						//		System.out.println(abc+"   "+tok.get(s)+"  "+tok.size() +"  "+b);
							//	v1.add(b*idf.get(s));	
								 
							
				 
				
		
				 try {
						writer.write("---------------------"+s12+" ----------------------");
						writer.newLine();
		
		
				 
				 
				  Set<Entry<String, Double>> set = cosine.entrySet();
			        List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(set);
			        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			            public int compare(Map.Entry<String, Double> o1,
			                    Map.Entry<String, Double> o2) {
			                return o2.getValue().compareTo(o1.getValue());
			            }
			        });
			    //   Entry.values().removeAll(Collections.singleton(NaN));
int i1=1;

			        for (Entry<String, Double> entry : list) {
			        
			        		if (!Double.isNaN(entry.getValue())) {
			       
			     //    System.out.println(entry.getValue()+" "+entry.getKey());
			         writer.write(t+"       "+entry.getKey()+"     "+i1+"     "+entry.getValue());
					 
						writer.newLine();
					i1++;
			        	} 
			        		
			        }
			 //    t1++;
			        cosine.clear();
				
					}
		
				
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			    }
				 
				// for (Map.Entry<String, Double> e : cosine.entrySet()) {
						
						
				//	 System.out.println(e.getKey()+"   "+e.getValue());
				// }
				 
             //}
		
		 
	public static void coss (String s, List<Float> v1,List<Float> v2)
	{
		 float dotProduct = 0, normA=0, normB=0;
         for (int i = 0; i < v1.size(); i++)
         {
             dotProduct += (v1.get(i) * v2.get(i));
             normA += Math.pow(v1.get(i), 2);
             normB += Math.pow(v2.get(i), 2);
            
             
         }

       //  System.out.println(dotProduct/(Math.sqrt(normA) * Math.sqrt(normB)));
         
     double cos=(dotProduct/(Math.sqrt(normA) * Math.sqrt(normB)));
     cosine.put(s,cos);
		
	}


	private static boolean containsKey(String s) {
		// TODO Auto-generated method stub
		return false;
	}


	private void writeContent1(HashMap<String , Double> hashMap, BufferedWriter writer) {

		try {
			writer.write("---------------------file cosine ----------------------");
			writer.newLine();
		//	writer.write("Doc ID      -    WordID : Frequencies");

			writer.newLine();
		for (Map.Entry<String,Double> e : hashMap.entrySet()) {
			String abc=	e.getKey();
				double val=e.getValue();
				//writer.write("    " + fileDict.get(abc) );
			//	writer.write("    " + abc );
				
		
				
				        writer.write(" " +abc +"  "+val);
				        writer.newLine();

				 }
					
				
				
			
		}
				
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	private void writeContent2(HashMap<String , Map<String, Integer>> hashMap, BufferedWriter writer) {

		try {
			writer.write("--------------------INVERTED INDEX-----------------------");
			writer.newLine();
			writer.write("Word ID     -    Doc ID : Frequencies");

			writer.newLine();
		for (Map.Entry<String,Map<String, Integer>> e : hashMap.entrySet()) {
			String abc=	e.getKey();
				e.getValue();
				//writer.write("    " + wordDict.get(abc) );
				writer.write("    " + abc );
				Map<String, Integer> tok = e.getValue();
				 for (Map.Entry<String, Integer> entry : tok.entrySet()) {
				        String key = entry.getKey();
				        Integer value = entry.getValue();
				     //   writer.write(" " +fileDict.get(key) + " :" + value +"  ");
				        writer.write(" " +key + " :" + value +"  ");
				 }
					writer.newLine();
				
				
					}
		}
				
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	/**
	 * 
	 * @return list of lists containing the content from the files.
	 */


	public void loadData1() {
		List<String> filesList = loadFiles("./src/ft911/");
	
		for (String fileName : filesList) {
			readFileContent(fileName);

		
		}

	

	}

	public void tokenizeContent1(Set<String> content) {

		Set<String> tokens1 = new HashSet<>();
		// Load stop list if its not yet loaded.
		if (stopList.isEmpty()) {
			stopList = loadStopList();
		}

		for (String data : content) {
			// Removing strings with numbers and then considering words
			// without punctuation.
			tokens1.addAll(
					Arrays.asList((data.toLowerCase().replaceAll("\\w*\\d\\w*", "").trim().split("\\s*[^a-z]\\s*"))));
		}

		tokens1 = checkStopList(tokens1);

		stemWords1(tokens1);
	}

	
	public Set<String> checkStopList(Set<String> tokensTOCheck) {
		tokensTOCheck.removeAll(stopList);
		return tokensTOCheck;

	}
	private void stemWords1(Set<String> tokens1) {
		Porter porter = new Porter();
		TreeSet<String> sortedTokens = new TreeSet<String>(Collator.getInstance());
		for (String stemWords : tokens1) {
			if (!stemWords.isEmpty()) {
				sortedTokens.add(porter.stripAffixes(stemWords.trim()));
			}
		}

		for (String string : sortedTokens) {
			if (!string.isEmpty()) {
				wordDict.put(string, ++index);
				
			}
		}
index=0;
	}
	
	
	/**
	 * 
	 * @param path
	 *            to the folder containing the files.
	 * @return list of files to be read.
	 */
	private static List<String> loadFiles(final String path) {
		List<String> filesToLoad = new ArrayList<>();
		File folder = new File(path);
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isFile()) {
				filesToLoad.add(fileEntry.getAbsolutePath());
			}
		}
		return filesToLoad;

	}

	private static List<String> loadStopList() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("./src/stopwordlist.txt"));
			while ((line = reader.readLine()) != null) {
				stopList.add(line.trim());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stopList;
	}

	private void readFileContent1(String fileToRead) {
		

		BufferedReader bufferedReader = null;
		String docNumber = null;
		String textLine = null;
	

		try {
			bufferedReader = new BufferedReader(new FileReader(fileToRead));
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains(DOC_START_TAG)) {
					docNumber = line.substring(line.indexOf(DOC_START_TAG) + DOC_START_TAG.length(),
							line.indexOf(DOC_END_TAG));
					
					fileDict.put(docNumber, ++counter);

				} else if (line.contains(TEXT_START_TAG)) {
					while (!(textLine = bufferedReader.readLine()).contains(TEXT_END_TAG)) {
						content.add(" " + textLine);
						
					}
				}
				/*
				 * if (readInputDatatype != null && counter > 0 &&
				 * readInputDatatype.getmDocId() != null &&
				 * readInputDatatype.getmDocText() != null &&
				 * !readInputDatatype.getmDocText().equals("")) {
				 * readinputDataList.add(readInputDatatype); readInputDatatype =
				 * new ReadInputDatatype(); }
				 */
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @param fileToRead
	 * @return list containing the data.
	 */
	private void readFileContent(String fileToRead) {
	

		BufferedReader bufferedReader = null;
		String docNumber = null;
		String textLine = null;
	

		try {
			bufferedReader = new BufferedReader(new FileReader(fileToRead));
		while ((line = bufferedReader.readLine()) != null) {
		
				if (line.contains(DOC_START_TAG)) {
					docNumber = line.substring(line.indexOf(DOC_START_TAG) + DOC_START_TAG.length(),
							line.indexOf(DOC_END_TAG));
					
					fileDict.put(docNumber, ++counter );

				} else if (line.contains(TEXT_START_TAG)) {
					while (!(textLine = bufferedReader.readLine()).contains(TEXT_END_TAG)) {
					content.add(" " + textLine);
						test.add(" " + textLine);
						test4.add(" " + textLine);

					
					}
					
					
					for (String data : test) {
						
					test2.addAll(
							Arrays.asList((data.toLowerCase().replaceAll("\\w*\\d\\w*", "").trim().split("\\s*[^a-z]\\s*"))));

								
					}
				
					
					test3=tokenizeContent(test2);
			
          findex.put(docNumber, freq(test3));
				


				}	
				
			
				test2.clear();
				test.clear();
				

				/*
				 * 
				 * if (readInputDatatype != null && counter > 0 &&
				 * readInputDatatype.getmDocId() != null &&
				 * readInputDatatype.getmDocText() != null &&
				 * !readInputDatatype.getmDocText().equals("")) {
				 * readinputDataList.add(readInputDatatype); readInputDatatype =
				 * new ReadInputDatatype(); }
				 */
			}
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		tokenizeContent1(content);

		
		
	
		
		test4 = tokenizeContent(test4);
	
		Set<String> set1 = new HashSet<String>(test4);
		

		HashMap<String, Integer> s2 = new HashMap<>();

		for (String temp : set1) {
	 
	       
		s2=	checkword(temp);		
	     
	
		 iindex.put(temp, s2);
		}

		
		
		
		
	}

	/**
	 * 
	 * @param content
	 *            total word set that has to be tokenized
	 */
	public static List<String> tokenizeContent(List<String> test1) {
	

		List<String> tokens = new ArrayList<>();
	
		if (stopList.isEmpty()) {
			stopList = loadStopList();
		}

		for (String data : test1) {
			
		tokens.addAll(
				Arrays.asList((data.toLowerCase().replaceAll("\\w*\\d\\w*", "").trim().split("\\s*[^a-z]\\s*"))));

					
		}
	
		
		tokens = checkStopList(tokens);
		List<String> final11 = new ArrayList<>();

		Porter porter = new Porter();
		
		for (String stemWords : tokens) {
			if (!stemWords.isEmpty()) {
				final11.add(porter.stripAffixes(stemWords.trim()));
			}
		}

		
		
return final11;
	
	}

	
	public static void giveout(String word)
	{
		Porter porter = new Porter();
		
	String word1=	porter.stripAffixes(word.trim());

	
	Map<String, Integer> a =new HashMap<String, Integer>();
	a= iindex.get(word1);
	
	 System.out.println(" The Inverted Index is    ");
     System.out.println(" wordID1:  docId1: freq in docID1; docId2: freq in docID2; ………. ");
   //  System.out.print(  wordDict.get(word1)+"  :  " );
     System.out.print(word1+"  :  " );
     for (Map.Entry<String, Integer> entry : a.entrySet()) {
	        String key = entry.getKey().toString();
	        Integer value = entry.getValue();
		    
	 //    System.out.print(" " + fileDict.get(key) + " : " + value +"     ");
	     System.out.print(" " + key + " : " + value +"     ");
 	  }
 	    System.out.println();
 	   System.out.println();
 	   System.out.println();
 	 System.out.println(" The word is in the following Document   ");
     System.out.println(" Document : Frequency  "+a.size());
 	  for (Map.Entry<String, Integer> entry : a.entrySet()) {
	        String key = entry.getKey().toString();
	        Integer value = entry.getValue();
		    
	   //  System.out.println(" " + key + "   :   " + value +"  ");
 	  }
	}
	
		/**
	 * 
	 * @param tokens
	 *            The list of words after dividing into tokens.
	 * @return
	 */
	public static List<String> checkStopList(List<String> tokensTOCheck) {
		tokensTOCheck.removeAll(stopList);
		return tokensTOCheck;

	}
	

	
	public Map<String, Integer> freq(List<String> test1)
	{

	HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
	for (String word : test1) {
	    if (!word.isEmpty()) {
	        Integer frequency = frequencies.get(word);

	        if (frequency == null) {
	            frequency = 0;
	        }

	        ++frequency;
	        frequencies.put(word, frequency);
	    

	    }
	
	   
	    }

return frequencies;
	}
	
	
	public HashMap<String, Integer> checkword(String samp)
	{
		HashMap<String, Integer> s2 = new HashMap<>();
	 for (Map.Entry<String,Map<String, Integer>> e : findex.entrySet()) {
 		String abc=	e.getKey();
 			e.getValue();
 
 			Map<String, Integer> tok = e.getValue();
 		
			     
 				 if(tok.containsKey(samp))
 						{
 					   int value = tok.get(samp);
 					s2.put(abc, value);
 					
 				
 			
 			 }
 	
 			
 				}
	 
	
	 return s2;
	}
}