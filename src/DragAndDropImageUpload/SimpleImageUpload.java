/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DragAndDropImageUpload;

import MyLibrairies.MouseEvents.ShowImage;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author polina
 */
public class SimpleImageUpload extends javax.swing.JPanel {

    /**
     * Creates new form SimpleImageUpload
     */
    
       
        
    
    public SimpleImageUpload() {
        initComponents();
    }
    
    private FlowLayout fl; 
    int width = 120,height=145;
    
    public void setup() {
        // Create the drag and drop listener
    MyDragDropListener myDragDropListener = new MyDragDropListener();

    // Connect the label with a drag and drop listener
         fl = new FlowLayout();
         Scrollable.setLayout(fl);
        Scrollable.setAutoscrolls(true);
        myDragDropListener.setScrollable(Scrollable);
        new DropTarget(Scrollable, myDragDropListener);
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Scrollable = new javax.swing.JPanel();
        ADDButton = new javax.swing.JLabel();

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout ScrollableLayout = new javax.swing.GroupLayout(Scrollable);
        Scrollable.setLayout(ScrollableLayout);
        ScrollableLayout.setHorizontalGroup(
            ScrollableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        ScrollableLayout.setVerticalGroup(
            ScrollableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Scrollable);

        ADDButton.setText("ADD Image");
        ADDButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(ADDButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADDButton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private final void AddMignature(final String Path){
        
            Dimension d = new Dimension(width, height);
            
                JLabel mignatures ;
            if ((Path.toLowerCase().contains(".bmp"))
                        || (Path.toLowerCase().contains(".jpg"))
                        || (Path.toLowerCase().contains(".png"))
                        ) {

                    ImageIcon imageIcon = new ImageIcon(Path);
                    Image image = imageIcon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    imageIcon = new ImageIcon(newimg);
                    mignatures = new JLabel(imageIcon);
                    mignatures.setPreferredSize(d);
                    Scrollable.add(mignatures);
                } else {
                String[] fileNames = Path.split("\\");
                String fileName = fileNames[fileNames.length-1];
                    JOptionPane.showMessageDialog(this, "Fichier Invalide", "Le fichier : "
                            + fileName + " est invalide\nVeuillez selectionner une image!", JOptionPane.ERROR_MESSAGE);
                }
                Scrollable.validate();
                Scrollable.revalidate();
                Scrollable.repaint();
 
    }
    
    private void ADDButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDButtonMouseClicked
         
        JFileChooser jfc = new JFileChooser();
        int showOpenDialog = jfc.showOpenDialog(this);
        if (showOpenDialog == JFileChooser.APPROVE_OPTION) {

            Dimension d = new Dimension(width, height);
            File selectedFiles = jfc.getSelectedFile();
            JLabel mignatures ;
            if ((selectedFiles.getAbsolutePath().toLowerCase().contains(".bmp"))
                        || (selectedFiles.getAbsolutePath().toLowerCase().contains(".jpg"))
                        || (selectedFiles.getAbsolutePath().toLowerCase().contains(".png"))
                        ) {

                    ImageIcon imageIcon = new ImageIcon(selectedFiles.getAbsolutePath());
                    Image image = imageIcon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    imageIcon = new ImageIcon(newimg);
                    mignatures = new JLabel(imageIcon);
                    mignatures.setPreferredSize(d);
                    
                    mignatures.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent me) {
                            System.out.println("click");
                            if (me.getButton()==1) {
                                new ShowImage().ShowFullImage(selectedFiles.getAbsolutePath());
                            }
                            else{
                                System.out.println("button"+me.getButton());
                            }
                        }

                        
});
                    
                    Scrollable.add(mignatures);
                } else {
                    JOptionPane.showMessageDialog(this, "Fichier Invalide", "Le fichier : "
                            + selectedFiles.getName() + " est invalide\nVeuillez selectionner une image!", JOptionPane.ERROR_MESSAGE);
                }
                Scrollable.validate();
                Scrollable.revalidate();
                Scrollable.repaint();
 
        }
    }//GEN-LAST:event_ADDButtonMouseClicked


    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADDButton;
    private javax.swing.JPanel Scrollable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
