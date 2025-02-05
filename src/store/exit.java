package store;


public class exit {

	public exit() {
		System.out.println("welcome to our store\n"
				+ "1.login\n2. create new account");
			
			
			switch(Main.s.nextInt()) {
			case 1:
				Main.login();
				break;
				
				default:
					Main.createacc();
					break;
			}
				}
	}
	

