package uni;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class MyFrame extends JFrame {
	
	JPanel p = new JPanel();
	JPanel p2 = new JPanel();
	JButton btn1 = new JButton("Добавяне на стока");
	JButton btn2 = new JButton("Промяна на стока");
	JButton btn3 = new JButton("Изтриване на стока");
	JButton btn4 = new JButton("Преглед на стока");
	JButton btn5 = new JButton("Добавяне на магазин");
	JButton btn6 = new JButton("Промяна на магазин");
	JButton btn7 = new JButton("Изтриване на магазин");
	JButton btn8 = new JButton("Добавяне на стока на магазин");
	JButton btn9 = new JButton("Преглед на стока на магазин");
	JLabel label1 = new JLabel("Система за Управление на Стоки и Магазин");
	
	ArrayList<Goods> list = new ArrayList<>();
	ArrayList<Shop> list2 = new ArrayList<>();
	ArrayList<Goods> list3 = new ArrayList<>();
	
public  MyFrame() {

		this.setSize(1400,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		label1.setHorizontalAlignment(JLabel.CENTER);

        Dimension buttonSize = new Dimension(150, 30);
        btn1.setPreferredSize(buttonSize);
        btn2.setPreferredSize(buttonSize);
        btn3.setPreferredSize(buttonSize);
        btn4.setPreferredSize(buttonSize);
        Dimension buttonSize2 = new Dimension(250, 30);
        btn5.setPreferredSize(buttonSize2);
        btn6.setPreferredSize(buttonSize2);
        btn7.setPreferredSize(buttonSize2);
        btn8.setPreferredSize(buttonSize2);
        btn9.setPreferredSize(buttonSize2);

        EmptyBorder buttonBorder = new EmptyBorder(65, 20, 5, 10);
        p.setBorder(buttonBorder);
        EmptyBorder buttonBorder2 = new EmptyBorder(5, 10, 5, 20);
        p2.setBorder(buttonBorder2);
        EmptyBorder labelnBorder = new EmptyBorder(25, 10, 5, 10);
        label1.setBorder(labelnBorder);

    	this.add(label1, BorderLayout.NORTH);
    	
		p.setLayout(new GridLayout(5,1));
		p.add(btn1);
		p.add(btn2);
		p.add(btn3);
		p.add(btn4);
		this.add(p, BorderLayout.WEST);

		p2.setLayout(new GridLayout(5,1));
		p2.add(btn5);
		p2.add(btn6);
		p2.add(btn7);
		p2.add(btn8);
		p2.add(btn9);
	
		this.add(p2, BorderLayout.EAST);
		
		btn1.addActionListener(new AddProduct());
		btn2.addActionListener(new ChangeProduct ());
		btn3.addActionListener(new DeleteProduct());
		btn4.addActionListener(new ViewProduct());
		btn5.addActionListener(new AddShop());
		btn6.addActionListener(new ChangeShop());
		btn7.addActionListener(new DeleteShop());
		btn8.addActionListener(new AddGoodsToShop());
		btn9.addActionListener(new ViewGoodsOfShop());
		
		this.setVisible(true);
	}
 	class AddProduct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			String name = JOptionPane.showInputDialog("Име:");
			while(name.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Трябва да попълните полето!", "Внимание", JOptionPane.INFORMATION_MESSAGE);
				 name = JOptionPane.showInputDialog("Име:");
			}
            String category = JOptionPane.showInputDialog("Категория:");
            String quantitySTR = JOptionPane.showInputDialog("Количество(бр.):");
            String priceSTR = JOptionPane.showInputDialog("Цена(лв.):");
            String producer = JOptionPane.showInputDialog("Производител:");
           
            int quantity = Integer.parseInt(quantitySTR);
            float price = Float.parseFloat(priceSTR);
            
            Goods newGoods = new Goods(name, category, quantity, price, producer);
            list.add(newGoods);
            System.out.println("Goods List:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i+1)+"." + list.get(i).getName() + " - " + list.get(i).getCategory() + " - " + list.get(i).getQuantity()
                        + " - " + list.get(i).getPrice() + " - " + list.get(i).getProducer());
            }

        }
    }
 	class ChangeProduct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			 Goods selectedGoods = (Goods) JOptionPane.showInputDialog(null,
	                    "Select a product to change:", "Select Product", JOptionPane.QUESTION_MESSAGE,
	                    null, list.toArray(), list.get(0));

	          if (selectedGoods != null) {
	               
	        	String newName = JOptionPane.showInputDialog("Въвете ново име:", selectedGoods.getName());
	        	while(newName.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Трябва да попълните полето!", "Внимание", JOptionPane.INFORMATION_MESSAGE);
					 newName = JOptionPane.showInputDialog("Въвете ново име:");
				}
                String newCategory = JOptionPane.showInputDialog("Въведете нова категория:", selectedGoods.getCategory());
                String newQuantity = JOptionPane.showInputDialog("Въведете ново количество(бр.):", selectedGoods.getQuantity());
                String newPrice = JOptionPane.showInputDialog("Въведете нова цена(лв.):", selectedGoods.getPrice());
                String newProducer = JOptionPane.showInputDialog("Въведете нов производител:", selectedGoods.getProducer());

                selectedGoods.setName(newName);
                selectedGoods.setCategory(newCategory);
                selectedGoods.setQuantity(Integer.parseInt(newQuantity));
                selectedGoods.setPrice(Float.parseFloat(newPrice));
                selectedGoods.setProducer(newProducer);

                JOptionPane.showMessageDialog(null, "Информацията е подновена",
	                       null, JOptionPane.INFORMATION_MESSAGE); 
		}
		}
 	}
 	class DeleteProduct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Goods selectedGoods = (Goods) JOptionPane.showInputDialog(null,  "Изберете стока", "Избор на стока",
					JOptionPane.QUESTION_MESSAGE,null, list.toArray(), list.get(0));
				
			int confirmDelete = JOptionPane.showConfirmDialog(null,"Сигурни ли сте, че искате на изтриете магазина?",
																"Потвърджение", JOptionPane.YES_NO_OPTION);

            if (confirmDelete == JOptionPane.YES_OPTION){
	            list.remove(selectedGoods);

	            for (int i = 0; i < list.size(); i++) {
	                  System.out.println((i + 1) + "." + list.get(i).getName() + " - " + list.get(i).getCategory()
	                                + " - " + list.get(i).getQuantity() + " - " + list.get(i).getPrice() + " - "
	                                + list.get(i).getProducer());
	           }

            JOptionPane.showMessageDialog(null,"Изтриването беше успешно!");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Изтриването беше отменено!");
	          }
	    }		
 	}
	class ViewProduct implements ActionListener{

		@Override
			public void actionPerformed(ActionEvent e) {
				Goods selectedGoods = (Goods) JOptionPane.showInputDialog(null,
						"Изберете стока", "Избор на стока", JOptionPane.QUESTION_MESSAGE,
	                    null, list.toArray(), list.get(0));
	
                String productInfo = "Продукт: " + selectedGoods.getName() + "\n"
									+ "Категория: " + selectedGoods.getCategory() + "\n"
									+ "Количество(бр.): " + selectedGoods.getQuantity() + "\n"
									+ "Цена(лв.): " + selectedGoods.getPrice() + "\n"
									+ "Производител: " + selectedGoods.getProducer();

                JOptionPane.showMessageDialog(null, productInfo, "Product Information", JOptionPane.INFORMATION_MESSAGE);
			}
	
	}
	class AddShop implements ActionListener{

		@Override

		public void actionPerformed(ActionEvent e) {

			String nameOfShop = JOptionPane.showInputDialog("Име");
			while(nameOfShop.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Трябва да попълните полето!", "Внимание", JOptionPane.INFORMATION_MESSAGE);
				nameOfShop = JOptionPane.showInputDialog("Въвете ново име:");
			}
		    String adress = JOptionPane.showInputDialog("Адрес");
		           
		    Shop newShop = new Shop(nameOfShop, adress);
          	list2.add(newShop);
            System.out.println("Shop List:");
	            for (int i = 0; i < list2.size(); i++) {
	                System.out.println((i+1)+"." + list2.get(i).getNameOfShop() + " - " + list2.get(i).getAdress()) ;
	           }
	     }
	}
	class ChangeShop implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Shop selectedShop = (Shop) JOptionPane.showInputDialog(null,"Изберете магазин","Избор на магазин",
					JOptionPane.QUESTION_MESSAGE,null, list2.toArray(), null);
				
			if(selectedShop != null) {
					
				String newShop =JOptionPane.showInputDialog( "Изберете име",selectedShop.getNameOfShop());
				while(newShop.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Трябва да попълните полето!", "Внимание", JOptionPane.INFORMATION_MESSAGE);
					newShop = JOptionPane.showInputDialog("Въвете ново име:");
				}
				String newAdress =JOptionPane.showInputDialog( "Изберете адрес",selectedShop.getAdress());
					
				selectedShop.setNameOfShop(newShop);
				selectedShop.setAdress(newAdress);
					
				JOptionPane.showMessageDialog(null,"Информацията е подновена",null, JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Shop List:");
				for(int i =0; i<list2.size();i++) {
					System.out.println((i+1) + list2.get(i).getNameOfShop() + "-" + list2.get(i).getAdress());
				}
			}
		}
	}
   class DeleteShop implements ActionListener{

	 @Override
	 public void actionPerformed(ActionEvent e) {
		Shop selectedShop = (Shop) JOptionPane.showInputDialog(null,"Изберете магазин","Избор на магазин",
				JOptionPane.QUESTION_MESSAGE,null, list2.toArray(), null);
		if(selectedShop != null) {
			int confirmDel = JOptionPane.showConfirmDialog(null, "Сигурни ли сте, че искате на изтриете магазина","Потвърджение",
					JOptionPane.YES_NO_OPTION);
			
			if (confirmDel == JOptionPane.YES_OPTION) {
				list2.remove(selectedShop);
				System.out.println("Shop List:");
				for(int i =0; i<list2.size();i++) {
					System.out.println((i+1) + list2.get(i).getNameOfShop() + "-" + list2.get(i).getAdress());
				}
				JOptionPane.showMessageDialog(null, "Изтриването беше успешно!", null, JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Изтриването беше отменено!", null, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	 }
			
	}
   class AddGoodsToShop implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Shop selectedShop = (Shop) JOptionPane.showInputDialog(null,"Изберете магазин","Избор на магазин",
				JOptionPane.QUESTION_MESSAGE,null, list2.toArray(), null);
		if(selectedShop != null) {
			String name = JOptionPane.showInputDialog("Име:");
			while(name.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Трябва да попълните полето!", "Внимание", JOptionPane.INFORMATION_MESSAGE);
				name = JOptionPane.showInputDialog("Въвете име:");
			}
			String category = JOptionPane.showInputDialog("Категория:");
			String quantitySTR = JOptionPane.showInputDialog("Количество(бр.):");
            String priceSTR = JOptionPane.showInputDialog("Цена(лв.)");
            String producer = JOptionPane.showInputDialog("Производител");
           
            int quantity = Integer.parseInt(quantitySTR);
            float price = Float.parseFloat(priceSTR);
            
            Goods newGoods = new Goods(name, category, quantity, price, producer );
            list3.add(newGoods);
            
			System.out.println("Goods List of " + selectedShop + " :");
            for (int i = 0; i < list3.size(); i++) {
                System.out.println((i+1)+"." + list3.get(i).getName() + " - " + list3.get(i).getCategory() + " - " + list3.get(i).getQuantity()
                        + " - " + list3.get(i).getPrice() + " - " + list3.get(i).getProducer());
            }
            
	}
	}   
   }
    class ViewGoodsOfShop implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Shop selectedShop = (Shop) JOptionPane.showInputDialog(null,"Избор на магазин", "Изберете магазин ",
					JOptionPane.QUESTION_MESSAGE, null, list2.toArray(), list2.get(0));
			if(selectedShop != null) {
				Goods selectedGoods = (Goods) JOptionPane.showInputDialog(null, "Изберете стока", "Избор на стока",
                                           JOptionPane.QUESTION_MESSAGE, null , list3.toArray(), list3.get(0));
				if(selectedGoods != null) {
					String productInfo = "Продукт: " + selectedGoods.getName() + "\n"
											+ "Категория: " + selectedGoods.getCategory() + "\n"
											+ "Количество: " + selectedGoods.getQuantity() + "\n"
			                                + "Цена(лв.): " + selectedGoods.getPrice() + "\n"
			                                + "Производител: " + selectedGoods.getProducer();
							JOptionPane.showMessageDialog(null, productInfo, "Информация за продукта" , JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
}		
