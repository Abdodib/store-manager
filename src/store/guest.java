package store;

import java.util.ArrayList;

public class guest extends account{
	private ArrayList<item> cart;
	public guest() {
		cart = new ArrayList<>();
	}

	public guest(String name, String phonenumber, String email, String password) {
		super(name, phonenumber, email, password);
		}

	@Override
	void menu(ArrayList<account>account,ArrayList<item> menu) {
		System.out.println("-1. exit\n0. checkout");
		for (item m: menu) {
			int index = menu.indexOf(m) +1;
		System.out.println(index + ". "+m.getItemName()+"\t" + m.getPrice() + "$");
		System.out.println();
		
		}
		int choice = Main.s.nextInt(); 
		    switch (choice) {
		    case -1:
			new exit();
		    case 0 :
		    	double sum = 0;
		    	System.out.println("are you sure that you want to buy these item?");
		    	for(item m : cart) {
		    		System.out.print(m.getItemName()+ "\t" + m.getPrice());
		    	sum = sum + m.getPrice();
		    	}
		    	System.out.println("Sum =" + sum);
		    	System.out.print("1. continue\n2. cancel ");
		    	if(Main.s.nextInt() == 1) {
		    		System.out.println("operation done \n THANK YOU");
		    	}
		    		cart.clear();
		    		menu(account,menu);
		    		break;
		    	
		    	default:
		    		if (menu.size() >= choice) {
		    			cart.add(menu.get(choice - 1));
		    		System.out.println("item added successfully");
		    		}else {
		    			System.out.println("item doesn't exist");
		    		}
		    		
		    		menu(account,menu);
		    		break;
		}
	}
		
	
}
