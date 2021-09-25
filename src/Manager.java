import java.util.Collections;
public class Manager {

	List<String> Order = new List<String>();
	List<String> Uniques = new List<String>();
	Queue<List> OrderQueue = new Queue<List>();
	
	int OrderNumber = 0;
	
	public void addList(String pInput) {
		Order.append(pInput);
	}
	
	public int getOrderAmount(String pProduct) {
		int Anzahl = 0;
		Order.toFirst();
		for(int i = 0; Order.hasAccess(); i++) {
			if(Order.getContent().equals(pProduct)) {
				Anzahl++;
			}
			Order.next();
		}
		return Anzahl;
	}
	
	
	public void findUnique() {
		
		//clears uniques then finds the uniques
		Uniques.toFirst();
		while(Uniques.hasAccess()) {
			Uniques.remove();
		}
		
		int a  = 0;
		Order.toFirst();
		while(Order.hasAccess()) {
			a++;
			Order.next();
		}
		String[] array = new String[a];
		Order.toFirst();
		for(int h = 0;h<array.length;h++) {
			array[h] = Order.getContent();
			Order.next();
		}
		
		for(int i = 0; i<array.length; i++) {
			boolean isUnique = true;
			for(int j =0;j<i;j++) {
				if(array[i].equals(array[j])) {
					isUnique = false;
					break;
				}
			
			}
			if(isUnique) {
				Uniques.append(array[i]);
				
				System.out.println("Unique:"+array[i]);
			}
				
		}
		
	}


	public List<String> getUniques() {
		findUnique();
		return Uniques;
	}
	
	public void addOrder() {
		OrderNumber++;
		OrderQueue.enqueue(Order);
		//clear current order
		Order.toFirst();
		while(Order.hasAccess()) {
			Order.remove();
		}	
	}
	
	public int returnOrderNumber() {
		return OrderNumber;
	}
	
}
