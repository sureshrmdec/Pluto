package com.jiaxin.cc.Scalability;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 简单的设计题目
 * 
 * 1. Reduce Machine Jumps
 * 2. Smart Division of People and Machines
 * 3. Breadth First Search usually need marking visited
 * 4. Server Fail
 * 5. Cache
 * 6. 
 * @author jeffwan
 * @date May 18, 2014
 */
public class FacebookFriends {

	public class Server {
		HashMap<Integer, Machine> machines = new HashMap<Integer, Machine>();
		HashMap<Integer, Integer> personToMachineMap = new HashMap<Integer, Integer>();
		
		public int getMachineIDForUser(int personID) {
			Integer machineID = personToMachineMap.get(personID);
			return machineID == null ? -1 : machineID; 
		}
		
		public Machine getMachineIDWithID(int machineID) {
			return machines.get(machineID);
		}
	}
	
	public class Person {
		public int personID;
		public ArrayList<Integer> friendIDs;
		
		public Person(int personID) {
			this.personID = personID;
		}
		
		public void addFriend(int friendID) {
			friendIDs.add(friendID);
		}
	}
	
	public class Machine {
		public int machineID;
		public HashMap<Integer, Person> persons = new HashMap<Integer, Person>();
		
		public Person getPersonWithID(int personID) {
			return persons.get(personID);
		}
	}
	
}
