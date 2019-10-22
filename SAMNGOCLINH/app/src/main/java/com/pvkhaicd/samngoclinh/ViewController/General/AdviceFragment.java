package com.pvkhaicd.samngoclinh.ViewController.General;


import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pvkhaicd.samngoclinh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdviceFragment extends Fragment {
    String source = "<span class=\"char-style-override-5\">Sâm Ngọc linh là một giống cây quý hiếm được phát hiện mọc hoang tại hai tỉnh Quảng Nam và Kon Tum. Các nghiên cứu về đặc điểm sinh học, thành phần hóa học, tác dụng dược lý cho thấy cần phải được bảo tồn, nghiên cứu, phát triển, đặc biệt ở những vùng có địa hình cao, khí hậu mát mẻ như Đà Lạt, Sa Pa hay Tam Đảo. Đề tài “Nghiên cứu di thực Sâm Ngọc linh tại Tam Đảo” đã được Viện Dược liệu thực hiện từ năm 2009 và cho kết quả khả quan với 2 phương pháp trồng là: trong nhà mái che và trồng dưới tán rừng. BBT Thông tin KH&amp;CN xin giới thiệu cùng bạn đọc Quy trình kỹ thuật trồng Sâm Ngọc linh dưới dàn mái che, cụ thể như sau:</span></p>\n" +
            "<p class=\"Normal para-style-override-32\" style=\"text-align:justify\">\n" +
            "\t1. Kỹ thuật trồng:</p>\n" +
            "<p class=\"Normal para-style-override-33\" style=\"text-align:justify\">\n" +
            "\t* Chuẩn bị trước khi trồng:</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t- Đất: Chọn đất có độ cao trên 1000m, khá bằng phẳng, thoát nước tốt, cuốc ải phơi đất. Chuẩn bị vào vụ trồng cuốc đập đất nhỏ, nhặt sạch cỏ dại, phân luống rộng 120cm, luống dài khoảng 4m, vét luống cao 30-35cm, rãnh luống 30cm. Cuốc hố trên mặt luống thành hàng cách nhau 20cm, hàng cách hàng 30cm.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t* Làm nhà mái che: Làm nhà bằng lưới. Khung bằng gỗ hoặc tre, mái lợp lưới nilon đen, rào kín xung quanh để bảo vệ.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t* Phân bón: Chủ yếu là phân gà hoai mục. Lượng phân bón cho 1ha:</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t- 15 tấn phân gà dùng để bón lót.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t- 30kg đạm + 20kg lân + 20kg kali chia đều từ năm thứ nhất đến năm thứ 4.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t* Giống: Số lượng cây giống cho 1 ha sản xuất, trông với mật độ 20x30cm là 165.000 cây. Cây giống đạt các tiêu chuẩn giống cơ sở.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t* Thời vụ trồng: Thời vụ chính là tháng 8 hàng năm.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t* Trồng cây: Trồng cây trên nền phân gà đã đổ trong hố, sâu 5-7cm, ấn chặt gốc, vun một lớp đất mỏng kín hố, không để hố úng đọng nước gây thối củ.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\tCây giống đánh lên khỏi vườn ươm không được làm đứt củ giống, phân loại to nhỏ theo kích thước củ giống để đưa vào trồng đồng đều theo từng loại. Khoảng cách trồng là 20x30cm.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t* Chăm sóc: Cần giữ ẩm cho cây nhưng không để quá ẩm kéo dài gây thối củ. Làm rãnh thoát nước ngoài ruộng trồng, không để nước mưa tràn qua ruộng sâm, sau mưa phải tháo nước triệt để.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t- Nhổ cỏ bằng tay và vét rãnh luống, tháng 3 cho sâm nhú mầm, tháng 4-5 đảm bảo tưới giữ ẩm, tránh nắng hạn.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t- Trước tháng 6 làm vệ sinh vườn, vét rãnh luống, khơi thông hệ thống thoát nước, kiểm tra củng cố nhà mái che.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t- Cuối mùa mưa bón phân quanh gốc, vét rãnh luống, nhặt cỏ dại cho sâm ngủ đông.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t* Phòng trừ sâu bệnh:</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t- Cần thực hiện nghiêm ngặt từ khâu chọn đất, cày phơi ải, làm đất kỹ nhặt sạch cỏ dại và nhà mái che đúng chế độ chiếu sáng.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t- Chọn cây giống và phân loại cây giống chặt chẽ. Mùa mưa phải thoát nước kịp thời và triệt để. Thường xuyên thăm nom đồng ruộng, phát hiện cây sâu bệnh phải nhổ, đốt ngay, đổ vôi bột hay nước sôi vào gốc để diệt mầm bệnh. Đảm bảo nhà mái che trong mùa mưa.</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\t- Phòng trừ tổng hợp: Chọn cây giống đúng tiêu chuẩn, tiêu độc cho cây trước khi trồng. Chọn và làm đất đúng quy trình, hệ thống thoát nước nhanh và kịp thời. Vệ sinh đồng ruộng chặt chẽ, không để ánh sáng chiếu trực tiếp vào cây sâm.</p>\n" +
            "<p class=\"Normal para-style-override-19\" style=\"text-align:justify\">\n" +
            "\t2. Thu hoạch, chế biến và bảo quản:</p>\n" +
            "<p class=\"Normal para-style-override-4\" style=\"text-align:justify\">\n" +
            "\tSâm trồng từ nguồn cây giống có thời gian trên vườn ươm từ 24-36 tháng vì vậy chỉ sau 4 năm trồng đã cho thu hoạch củ. Thời gian thu hoạch khoảng tháng 11, 12 khi sâm bước vào giai đoạn ngủ đông sẽ cho chất lượng dược liệu cao nhất.</p>";

    public AdviceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.text);

        //set content
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(source, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(source));
        }
    }
}
