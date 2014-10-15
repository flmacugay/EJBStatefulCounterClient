package com.mac;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mac.stateful.BeanCounterRemote;


public class MainStateful {

	public static void main(String[] args) {
		Hashtable<String, String> ht=new Hashtable<>();
		ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		ht.put(Context.PROVIDER_URL, "t3://localhost:8080");
		
		try {
			Context ctx=new InitialContext(ht);
			BeanCounterRemote beanCounter=(BeanCounterRemote) ctx.lookup("BeanCounter#com.mac.stateful.BeanCounterRemote");
			beanCounter.addCount();
			System.out.println(beanCounter.getCount());
			
			BeanCounterRemote beanCounter2=(BeanCounterRemote) ctx.lookup("BeanCounter#com.mac.stateful.BeanCounterRemote");
			beanCounter2.addCount();
			System.out.println(beanCounter2.getCount());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
