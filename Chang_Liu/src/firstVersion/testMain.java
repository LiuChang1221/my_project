package firstVersion;

import java.util.ArrayList;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] order = {100,200,150,100};
		
		double total_Volume = 0.6 * 0.6 * 0.5 * order[0] + 0.3 * 0.3 * 0.2 * order[1] + 1.0 * 1.5 * 0.5 * order[2] + 1.2 * 1.4 * 0.8 * order[3];//total volume of the shipment
		double total_Weight = 6.5 * order[0] + 0.2 * order[1] + 20 * order[2] + 2.6 * order[3];//total weight of the shipment
		
		int small_container, big_container;
		small_container = big_container = 0;//the number of containers
		double[] Volume_container = {2.59 * 2.43 * 6.06 * small_container, 2.59 * 2.43 * 12.01 * big_container}; //the volume of the both containers
		ArrayList price = new ArrayList();
		ArrayList num_small = new ArrayList();
		ArrayList num_big = new ArrayList();
		
		for(small_container = 0; small_container <= (int)(total_Volume / Volume_container[0]); small_container++) {
			for(big_container = 0; big_container <= (int)(total_Volume / Volume_container[1]); big_container++) {	
				if(Volume_container[0] * small_container + Volume_container[1] * big_container >= total_Volume) {
					if(total_Weight <= 500) {
						price.add(small_container * 1000 + big_container * 1800);
					}else {
						price.add(small_container * 1200 + big_container * 1800);
					}
				num_small.add(small_container);
				num_big.add(big_container);
				}
			}
		}
		
		int m = 0;
		int least = 1200 * (int)(total_Volume / Volume_container[0])+ 1800 * (int)(total_Volume / Volume_container[1]);
		for(int i = 0; i < price.size(); i++) {
			if(least > (int)(price.get(i))) {
			   least = (int)(price.get(i));
				m = i;
			}
		}
		
		System.out.println(num_small.get(m) + " Small Containers");
		System.out.println(num_big.get(m) + " Big Containers");
		System.out.println(least);

    }
}
