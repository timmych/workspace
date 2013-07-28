//package com.xzz.data;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.JsonParseException;
//import org.codehaus.jackson.JsonParser.Feature;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//
//public class JsonData {
//
//	// "{"c":[{"ops":[{"op":"NONE","t":["ipad ipad","very expensive foo
//	// bar"]},{"op":"ANY","t":["kindle fire hd","digitial camera","some other
//	// electronics","camera"]}]}]}"
//
//	private Set<Container> c = new HashSet<Container>();
//
//	public Set<Container> getC() {
//		return c;
//	}
//
//	public void setC(Set<Container> c) {
//		this.c = c;
//	}
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//
//		Set<Dummy> s1 = new HashSet<Dummy>();
//		Set<Dummy> s2 = new HashSet<Dummy>();
//		Dummy myfoo = new Dummy("foo");
//		s1.add(myfoo);
//		s2.add(new Dummy("bar"));
//		s1.add(new Dummy("bar"));
//		s2.add(new Dummy("foo"));
//		s2.add(new Dummy("Foo".toLowerCase()));
//		System.out.println(s1.equals(s2));
//		System.out.println(s1.contains(new Dummy("foo")));
//		System.out.println(s1.contains(myfoo));
//		//
//		// // TODO Auto-generated method stub
//		// JsonData jd = new JsonData();
//		//
//		// Operation op1 = new Operation();
//		// op1.setOp("NONE");
//		// op1.getT().addAll(Arrays.asList("hello", "world"));
//		// Operation op2 = new Operation();
//		// op2.setOp("ANY");
//		// op2.getT().addAll(Arrays.asList("foo", "BAR"));
//		// jd.getC().add(new Container());
//		// jd.getC().toArray(new Container[0])[0].getOps().add(op1);
//		// jd.getC().toArray(new Container[0])[0].getOps().add(op2 );
//		//
//		// String s = formatPojoAsJson(jd);
//		// String ss =
//		// "{\"c\":[{\"ops\":[{\"op\":\"ANY\",\"t\":[\"t2\",\"t1\"]},{\"op\":\"NONE\",\"t\":[\"e1\",\"e2\"]}]}]}";
//		//
//		// System.out.println(s);
//		// System.out.println(ss);
//		// ObjectMapper j = new ObjectMapper().configure(Feature.ALLOW_COMMENTS,
//		// true);
//		// try {
//		// JsonData jdd = j.readValue(ss, JsonData.class);
//		// } catch (JsonParseException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// } catch (JsonMappingException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// } catch (IOException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//	}
//
//	private static ObjectMapper JSON_MAPPER = new ObjectMapper();
//
//	public static String formatPojoAsJson(Object aPojo) {
//		String val = "Unable to format string";
//		try {
//			val = JSON_MAPPER.writeValueAsString(aPojo);
//		} catch (JsonGenerationException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return val;
//	}
//}
