import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CityManagementApp extends JFrame {
    private City city;
    private JTextArea residentsTextArea;
    private JTextArea facilitiesTextArea;

    public CityManagementApp() {
        city = new City("Thành phố của tôi");

        setTitle("Ứng dụng Quản lý Thành phố");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        residentsTextArea = new JTextArea();
        residentsTextArea.setEditable(false);

        facilitiesTextArea = new JTextArea();
        facilitiesTextArea.setEditable(false);

        JButton addResidentButton = new JButton("Thêm Cư dân");
        addResidentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Nhập tên cư dân:");
                String ageStr = JOptionPane.showInputDialog("Nhập tuổi cư dân:");
                int age = Integer.parseInt(ageStr);

                Person person = new Person(name, age);
                city.addResident(person);
                updateResidentsTextArea();
            }
        });

        JButton removeResidentButton = new JButton("Xóa Cư dân");
        removeResidentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Nhập tên cư dân:");

                for (Person person : city.getResidents()) {
                    if (person.getName().equals(name)) {
                        city.removeResident(person);
                        break;
                    }
                }
                updateResidentsTextArea();
            }
        });

        JButton addFacilityButton = new JButton("Thêm Công trình công cộng");
        addFacilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Nhập tên công trình:");
                String address = JOptionPane.showInputDialog("Nhập địa chỉ công trình:");
                String areaStr = JOptionPane.showInputDialog("Nhập diện tích công trình:");
                double area = Double.parseDouble(areaStr);
                String facilityType = JOptionPane.showInputDialog("Nhập loại hình công trình:");

                PublicFacility facility = new PublicFacility(name, address, area, facilityType);
                city.addPublicFacility(facility);
                updateFacilitiesTextArea(); // Cập nhật TextArea sau khi thêm công trình mới
            }
        });

        JButton removeFacilityButton = new JButton("Xóa Công trình công cộng");
        removeFacilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String facilityName = JOptionPane.showInputDialog("Nhập tên công trình:");

                for (PublicFacility facility : city.getPublicFacilities()) {
                    if (facility.getName().equals(facilityName)) {
                        city.removePublicFacility(facility);
                        break;
                    }
                }
                updateFacilitiesTextArea(); // Cập nhật TextArea sau khi xóa công trình
            }
        });

        JPanel residentsButtonPanel = new JPanel();
        residentsButtonPanel.add(addResidentButton);
        residentsButtonPanel.add(removeResidentButton);

        JPanel facilitiesButtonPanel = new JPanel();
        facilitiesButtonPanel.add(addFacilityButton);
        facilitiesButtonPanel.add(removeFacilityButton);

        JPanel residentsPanel = new JPanel(new BorderLayout());
        residentsPanel.setBorder(BorderFactory.createTitledBorder("Cư dân"));
        residentsPanel.add(new JScrollPane(residentsTextArea), BorderLayout.CENTER);
        residentsPanel.add(residentsButtonPanel, BorderLayout.SOUTH);

        JPanel facilitiesPanel = new JPanel(new BorderLayout());
        facilitiesPanel.setBorder(BorderFactory.createTitledBorder("Công trình công cộng"));
        facilitiesPanel.add(new JScrollPane(facilitiesTextArea), BorderLayout.CENTER);
        facilitiesPanel.add(facilitiesButtonPanel, BorderLayout.SOUTH);

        add(residentsPanel, BorderLayout.WEST);
        add(facilitiesPanel, BorderLayout.EAST);

        updateResidentsTextArea(); // Cập nhật thông tin cư dân khi khởi động ứng dụng
        updateFacilitiesTextArea(); // Cập nhật thông tin công trình khi khởi động ứng dụng

        setVisible(true);
    }

    private void updateResidentsTextArea() {
        ArrayList<Person> residents = city.getResidents();
        StringBuilder sb = new StringBuilder();
        for (Person person : residents) {
            sb.append("Tên: ").append(person.getName()).append(", Tuổi: ").append(person.getAge()).append("\n");
        }
        residentsTextArea.setText(sb.toString());
    }

    private void updateFacilitiesTextArea() {
        ArrayList<PublicFacility> facilities = city.getPublicFacilities();
        StringBuilder sb = new StringBuilder();
        for (PublicFacility facility : facilities) {
            sb.append("Tên: ").append(facility.getName()).append(", Địa chỉ: ").append(facility.getAddress())
                    .append(", Diện tích: ").append(facility.getArea()).append(", Loại hình: ")
                    .append(facility.getFacilityType()).append("\n");
        }
        facilitiesTextArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CityManagementApp();
            }
        });
    }
}
