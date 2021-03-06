import java.util.ArrayList;

/**
 * kelas databasePesanan ini berisikan data dari pesanan yang
 * sudah dipesan dan selesai dipesan
 *
 * @author Kazhka Tirtandy
 * @version 1.7
 * @since 2018-02-22
 *
 */


public class DatabasePesanan
{
    private ArrayList<Pesanan> PESANAN_DATABASE;
    private int LAST_PESANAN_ID = 0;
    
    /**
     * method ini berfungsi untuk menambahkan pesanan baru
     * 
     * @return false
     */
    public boolean addPesanan(Pesanan baru){
        if (getPesananAktif(baru.getPelanggan())==null) {
            PESANAN_DATABASE.add(baru);
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * method ini berfungsi untuk menghapus pesanan yang telah usai
     * 
     * @pram pesan Parameter dengan tipe data pesanan
     * @return false
     */
    public boolean removePesanan(Pesanan pesan){
        boolean balik = false;
        int i;
        for (i=0; i<PESANAN_DATABASE.size(); i++) {
            if (PESANAN_DATABASE.get(i) == pesan) {
                if (PESANAN_DATABASE.get(i).getRoom() != null) {
                    Administrasi.pesananDibatalkan(PESANAN_DATABASE.get(i));
                    PESANAN_DATABASE.remove(i);
                    balik = true;
                } else if (PESANAN_DATABASE.get(i).getRoom() == null && PESANAN_DATABASE.get(i).getStatusAktif()) {
                    PESANAN_DATABASE.get(i).setStatusAktif(false);
                    PESANAN_DATABASE.remove(i);
                    balik = true;
                }
                break;
            }
    }
    /**
     * method ini berfungsi untuk menampilkan pesanan dari customer
     * 
     * @pram cust Parameter dengan tipe data customer
     * @return null
     */
    public Pesanan getPesanan(int id){
        boolean found = false;
        int i;
        for (i=0; i<PESANAN_DATABASE.size(); i++) {
            if (PESANAN_DATABASE.get(i).getID() == id) {
                found = true;
                break;
            }
        }
        if (found == true) {
            return PESANAN_DATABASE.get(i);
        }
        else {
            return null;
        }
    }

    /**
     * method ini berfungsi untuk menampilkan database dari pesanan
     * 
     * @return null
     */
    public Pesanan getPesanan(Room kamar) {
        boolean found = false;
        int i;
        for (i=0; i<PESANAN_DATABASE.size(); i++) {
            if (PESANAN_DATABASE.get(i).getRoom() == kamar) {
                found = true;
                break;
            }
        }
        if (found == true) {
            return PESANAN_DATABASE.get(i);
        }
        else {
            return null;
        }

    }
    public Pesanan getPesananAktif(Customer pelanggan) {
        boolean found = false;
        int i;
        for (i=0; i<PESANAN_DATABASE.size(); i++) {
            if (PESANAN_DATABASE.get(i).getPelanggan() == pelanggan ) {
                if (PESANAN_DATABASE.get(i).getStatusAktif() == true ) {
                    found = true;
                    break;
                }
            }
        }
        if (found == true) {
            return PESANAN_DATABASE.get(i);
        }
        else {
            return null;
        }
    }
    public ArrayList<Pesanan> getPesananDatabase(){
        return PESANAN_DATABASE;
    }
    /**
     * method ini berfungsi untuk menambahkan pesanan yang telah selesai
     * 
     * @pram pesan Parameter dengan tipe data pesanna
     * @return tidak ada
     */
    public void pesananDibatalkan(Pesanan pesan){
    }
    public int getLastPesananID() { return LAST_PESANAN_ID; }
    
}
