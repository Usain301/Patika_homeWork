import java.util.Scanner;

public class Ucak_bileti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Mesafeyi km türünden giriniz : ");
        int mesafe = input.nextInt();

        if (mesafe < 0) { // mesafe negatif ise hatalı veri girdiniz uyarısı
            System.out.println("Hatalı Veri Girdiniz !");
            return;
        }

        System.out.print("Yaşınızı giriniz : ");
        int yas = input.nextInt();

        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ): ");
        int yolculukTipi = input.nextInt();

        if (yolculukTipi != 1 && yolculukTipi != 2) { // yolculuk tipi 1 veya 2 değilse hatalı veri girdiniz uyarısı
            System.out.println("Hatalı Veri Girdiniz !");
            return;
        }

        double normalTutar = mesafe * 0.10; // normal bilet fiyatı

        double yasIndirimi = 0;
        if (yas < 0) { // yaş negatif ise hatalı veri girdiniz uyarısı
            System.out.println("Hatalı Veri Girdiniz !");
            return;
        } else if (yas < 12) {
            yasIndirimi = normalTutar * 0.5; // 12 yaşından küçüklerde %50 indirim
        } else if (yas < 24) {
            yasIndirimi = normalTutar * 0.1; // 12-24 yaş arasındakilerde %10 indirim
        } else if (yas >= 65) {
            yasIndirimi = normalTutar * 0.3; // 65 yaşından büyüklerde %30 indirim
        }

        double indirimliTutar = normalTutar - yasIndirimi; // yaş indirimi yapılmış fiyat

        double yolculukIndirimi = 0;
        if (yolculukTipi == 2) {
            yolculukIndirimi = indirimliTutar * 0.2; // gidiş dönüşte %20 indirim
        }

        double toplamTutar = (indirimliTutar - yolculukIndirimi) * yolculukTipi; // toplam bilet fiyatı

        System.out.println("Toplam Tutar = " + toplamTutar + " TL");
    }
}
