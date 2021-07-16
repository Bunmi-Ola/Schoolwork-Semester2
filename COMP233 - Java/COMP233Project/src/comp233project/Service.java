/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp233project;

import java.io.DataOutputStream;

/**
 *
 * @author olanrewaju4401
 */
public abstract class Service{
    
      private DataOutputStream responseWriter;	

	public Service( DataOutputStream responseWriter){
		this.responseWriter=responseWriter;
	}

	public abstract void doWork();
}
