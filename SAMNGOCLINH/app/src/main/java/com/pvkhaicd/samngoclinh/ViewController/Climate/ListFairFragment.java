package com.pvkhaicd.samngoclinh.ViewController.Climate;


import android.os.Bundle;

import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pvkhaicd.samngoclinh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFairFragment extends Fragment {

    String html = "<li><i class=\"linecon-icon-calendar\"></i>Ngày đăng: 15 Tháng Bảy, 2019</li>                           \n" +
            "</ul>\n" +
            "<div class=\"text\">\n" +
            "<p><em>Theo kế hoạch của UBND huyện Nam Trà My (Quảng Nam), Lễ hội sâm Ngọc Linh lần thứ III sẽ diễn ra từ ngày 1 đến ngày 03/8/2019.</em></p>\n" +
            "<p>Lễ hội Sâm Ngọc Linh lần này có chủ đề “Tỏa sáng Ngọc Linh”, với một loạt các hoạt động, bắt đầu bằng rước biểu tượng sâm Ngọc Linh vào lúc 15g chiều ngày 1/8/2019 từ vùng trồng sâm về Trung tâm Văn hóa thể thao huyện Nam Trà My; sau đó sẽ là chương trình khai mạc vào lúc 19g cùng ngày.</p>\n" +
            "<p>Trong suốt thời gian diễn ra Lễ hội Sâm Ngọc Linh, sẽ có phiên chợ sâm Ngọc Linh và hàng nông sản đặc trưng miền núi tỉnh Quảng Nam với quy mô khoảng 120 gian hàng của người dân các địa phương và doanh nghiệp tham gia.</p>\n" +
            "<div id=\"attachment_2454\" style=\"width: 660px\" class=\"wp-caption aligncenter\"><p id=\"caption-attachment-2454\" class=\"wp-caption-text\">Thời gian qua, việc tăng cường quảng bá giúp cho sâm Ngọc Linh ngày càng có giá trị hơn. Ảnh: Namtramy.gov.vn</p></div>\n" +
            "<p>Đáng chú ý nhất, là hội thi sâm Ngọc Linh vào ngày 1/8; trưng bày, triển lãm ảnh nghệ thuật về sâm Ngọc Linh, cây dược liệu và văn hóa của địa phương; các trò chơi dân gian,… trong thời gian diễn ra lễ hội.</p>\n" +
            "<p>Việc tổ chức Lễ hội sâm Ngọc Linh nhằm quảng bá hình ảnh cũng như giá trị thật sự của sâm Ngọc Linh – được xem là sản phẩm quốc gia, một dược liệu quý có giá trị kinh tế cao, mang thương hiệu đẳng cấp xứng tầm khu vực Đông Nam Á và trên thế giới.</p>\n" +
            "<p>Các hoạt động của lễ hội sẽ giới thiệu hình ảnh, tiềm năng, thế mạnh của vùng đất và con người Nam Trà My tới du khách trong và ngoài nước đồng thời kêu gọi cộng đồng cùng chung tay bảo vệ môi trường rừng nguyên sinh, bảo tồn và phát triển nguồn gen đặc hữu quí hiếm của sâm Ngọc Linh.</p>\n" +
            "<p style=\"text-align: right;\">An Vĩnh</p>";
    public ListFairFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_fair, container, false);
        TextView tv = view.findViewById(R.id.tv);
        tv.setText(HtmlCompat.fromHtml(html,0));
        return view;
    }

}
