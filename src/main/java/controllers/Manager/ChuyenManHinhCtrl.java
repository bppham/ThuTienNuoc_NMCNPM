/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Client.DanhMucModel;
import views.main.Manager.AssignmentPanel;
import views.main.Manager.ManagerHomePanel;
import views.main.client.ClientBill;
import views.main.client.ClientChangePassword;
import views.main.client.ClientHome;
import views.main.client.ClientInfo;
import views.main.Manager.ManagerProfile;
import views.main.Manager.ManagerWorker;
import views.main.Manager.ManagerWorkerPanel;

/**
 *
 * @author GIANG
 */
public class ChuyenManHinhCtrl {

    private JPanel root;
    private String kindSelected = "";

    List<DanhMucModel> listItem = null;

    public ChuyenManHinhCtrl(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "Home";
        jpnItem.setBackground(new Color(230, 255, 255));
        jlbItem.setBackground(new Color(230, 255, 255));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new ClientHome());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucModel> listItem) {
        this.listItem = listItem;
        for (DanhMucModel item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Nhân viên":
                    node = new ManagerWorkerPanel();
                    break;
                case "Phân công":
                    node = new AssignmentPanel();
                    break;
                default:
                    node = new ManagerHomePanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
           kindSelected = kind;
           jpnItem.setBackground(new Color(255, 255, 255));
           jlbItem.setBackground(new Color(255, 255, 255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(230, 255, 255));
            jlbItem.setBackground(new Color(230, 255, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255, 255, 255));
                jlbItem.setBackground(new Color(255, 255, 255));
            }
        }

    }

    private void setChangeBackground(String kind) {
        for (DanhMucModel item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(230, 255, 255));
                item.getJlb().setBackground(new Color(230, 255, 255));
            } else {
                item.getJpn().setBackground(new Color(255, 255, 255));
                item.getJlb().setBackground(new Color(255, 255, 255));
            }
        }
    }

}
