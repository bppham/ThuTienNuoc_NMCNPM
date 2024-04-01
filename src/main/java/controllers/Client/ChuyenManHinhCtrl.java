package controllers.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Client.DanhMucModel;
import views.main.client.ClientBill;
import views.main.client.ClientChangePassword;
import views.main.client.ClientChart;
import views.main.client.ClientHome;
import views.main.client.ClientInfo;
import views.main.client.ClientLogin;
/**
 *
 * @author Phu Bao
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
                case "Home":
                    node = new ClientHome();
                    break;
                case "Bill":
                    node = new ClientBill();
                    break;
                case "Info":
                    node = new ClientInfo();
                    break;
                case "ChangePassword":
                    node = new ClientChangePassword();
                    break;
                case "LogOut":
                    node = new ClientHome();
                    break;
                case "Chart":
                    node = new ClientChart();
                    break;                 
                default:
                    node = new ClientHome();
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