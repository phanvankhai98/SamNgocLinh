package com.pvkhaicd.samngoclinh.ViewController.Handbook;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pvkhaicd.samngoclinh.R;


public class AcknowledgeFragment extends Fragment {


    String source = "<p style=\"text-align: justify\"><strong>KỸ THUẬT TRỒNG VÀ CHĂM SÓC</strong></p>\n" +
            "<p style=\"text-align: justify\"><strong>1. Thời vụ</strong></p>\n" +
            "<p style=\"text-align: justify\">Với tiểu khí hậu vùng Ngọc Linh, có thể trồng Sâm quanh năm (trừ các tháng mùa mưa chính) nhưng do phụ thuộc vào điều kiện cây giống đủ tiêu chuẩn nên vụ trồng phổ biến từ tháng 7 &#8211; 9 hằng năm khi cây giống đạt 1 năm tuổi; ngoài ra, có thể trồng từ tháng 3-5 với cây giống lưu vườn hơn 1 năm tuổi. Không trồng vào những ngày nắng gắt hay mưa lớn.</p>\n" +
            "<p style=\"text-align: justify\"><strong>2. Thiết kế vườn và chuẩn bị đất trồng</strong></p>\n" +
            "<p style=\"text-align: justify\">Thực hiện nghiêm ngặt yêu cầu hạn chế tối đa những tác động bất lợi đến môi trường rừng, để vừa bảo vệ rừng, vừa tạo môi trường sống thích hợp cho sâm trồng.Sâm có thể sinh trưởng &#8211; phát triển tốt khi mọc sát gốc các cây gỗ, cây tái sinh.Trong thiết kế vườn và chuẩn bị đất trồng, chỉ phát dọn tối thiểu dây leo, bụi rậm; tuyệt đối không được tác động đến cây gỗ và cây tái sinh.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Lựa chọn đất trồng: Lựa chọn các vùng đất dưới tán rừng tự nhiên ở đai cao từ 1.500 m trở lên, còn giữ kết cấu rừng tự nhiên và có độ che phủ rừng từ 70% trở lên, giàu mùn, đủ ẩm.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Trong vùng lựa chọn, thiết kế các băng chừa và băng trồng đồng mức, xen kẽ nhau,rộng 8 – 10mét và chừa lại phần đỉnh trên cùng xuống đến băng trồng ít nhất 50mét.</p>\n" +
            "<p style=\"text-align: justify\">+ Phát dọn dây leo, bụi rậm để tạo các lối đi lại trong vườn Sâm: Lối đi lạigiữa các băng đồng mức,rộng 0,8 mét.Lối đi lại theo hướng dốc,rộng 0,8-1mét, thiết kếzích – zắc và với số lượng tối thiểu để hạn chế xói mòn.</p>\n" +
            "<p style=\"text-align: justify\">+ Đối với phần đỉnh dốc và băng chừa, giữ nguyên hiện trạng, nghiêm cấm mọi tác động.</p>\n" +
            "<p style=\"text-align: justify\">+ Đối với băng trồng, chỉ được phát dọn dây leo, bụi rậm.Trong các băng trồng, thiết kế 3-4 luống trồng, mỗi luống rộng 1,6 &#8211; 2,0 mét để trồng 3-4 hàng sâm. Giữa các luống, phát dọn dây leo, bụi rậmtạo lối đi lại rộng 30-35cm.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Chuẩn bị đất và trồng Sâm: Trên các luống trồng đã được phát dọn dây leo, bụi rậm, giữ nguyên hiện trạng mặt đất (không đánh rãnh lên luống; không thu dọn đá lẫn, gốc cây và thân gỗ chết…; chỉ thu gom thân lá dây leo, cây bụi vừa phát dọn để ủ phân hữu cơ). Đào hố trồng lan theo chiều nghiêng tự nhiên của khu vực trồng, theo quy cách và thẳng hàng để tiện trong việc theo dõi, chăm sóc sau này.</p>\n" +
            "<p style=\"text-align: justify\"><strong>3. Tiêu chuẩn cây giống trước khi trồng</strong></p>\n" +
            "<p style=\"text-align: justify\"><strong>3.1. Cây giống gieo từ hạt</strong></p>\n" +
            "<p style=\"text-align: justify\">Đối với cây giống 1 tuổi, phải đảm bảo các yêu cầu xuất vườn để trồng như sau:</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Về hình thái: Lá có màu xanh đến xanh đậm;</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Chiều cao thân trung bình: Từ 10 cm trở lên (lúc có 1 lá kép).</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Có đường kính củ từ 0,3 cm trở lên; có từ 2- 3 rễ chính trở lên.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Cây không bị bệnh hại trên thân, rễ, củ; bệnh trên lá nhỏ hơn 5% diện tích lá.</p>\n" +
            "<p style=\"text-align: justify\"><strong>3.2. Cây trồng từ đầu mầm</strong></p>\n" +
            "<p style=\"text-align: justify\">Cây giống đầu mầm là phần mầm của thân rễ (đoạn thân có các mắt) dài khoảng 3 &#8211; 4 cm (tính từ vị trí tiếp giáp với thân khí sinh), phía trên chừa lại 1 đoạn thân khí sinh dài 5 &#8211; 7 cm.</p>\n" +
            "<p style=\"text-align: justify\"><strong>4. Mật độ và cách trồng</strong></p>\n" +
            "<p style=\"text-align: justify\">&#8211; Khoảng cách, mật độ: Hàng cách hàng từ 40-45 cm, cây cách cây từ 30-35 cm;mật độ khoảng 20.000 –25.000 cây/ha rừng (tính bình quân trên diện tích thiết kế, bao gồm diện tích rừng không tác động).</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Cách trồng: Sử dụng cuốc nhỏ hoặc công cụ cầm tay phù hợp để đào hố tròn có đường kính 8-10 cm, sâu 6-8 cm để trồng.</p>\n" +
            "<p style=\"text-align: justify\">+ Trồng từ cây con: Bứng nhẹ, tách cây con trên vườn ươm hoặc trong khay, tránh xây xát và đứt rễ để đem đi trồng.</p>\n" +
            "<p style=\"text-align: justify\">Đặt cây con vào hố và điều chỉnh sao cho thân cây theo phương thẳng đứng, cổ rễ ngang với mặt đất tự nhiên; lấp đất và dùng tay ấn chặt đất xung quanh gốc cây; lấp đất theo hình mâm xôi để tránh cây bị úng khi mưa; nên trồng thẳng hàng để dễ theo dõi và tiện chăm sóc sau này; lưu ý không làm bể bầu, đứt rễ, dập nát cây khi trồng.</p>\n" +
            "<p style=\"text-align: justify\">+ Trồng bằng đầu mầm: Sau khi chuẩn bị xong đoạn mầm, có thể tiến hành trồng ngay; tương tự như trồng cây con, đào một hốc nhỏ sâu 5 &#8211; 7 cm rồi đặt phần thân mầm vào đó, đoạn thân khí sinh hướng lên trên, lấp đất và ấn chặt phần gốc.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Sau khi trồng, tưới nhẹ để ổn định cây, phủ một lớp lá khô lên mặt đất để giữ ẩm cho đất, hạn chế cỏ dại, đồng thời lá khô sau khi phân hủy sẽ cung cấp một lượng mùn nhất định cho cây sau này.</p>\n" +
            "<p style=\"text-align: justify\"><strong>5. Chăm sóc vườn sâm</strong></p>\n" +
            "<p style=\"text-align: justify\">&#8211; Năm đầu sau khi trồng, thường xuyên theo dõi, trồng dặm lại những cây chết (dặm các cây cùng lứa tuổi).</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Hằng năm,thường xuyên phát dọn các dây leo, bụi rậm tái sinh và nhổ cỏ trong vườn trồng sâm; chỉ cần cắt, nhổ cỏ cục bộ những cây sát gốc sâm; không cắt, nhổ cỏ khi cỏ không ảnh hưởng đến cây sâm. Không làm cỏ trong mùa mưa, nhất là giai đoạn cây ngủ đông để hạn chế rửa trôi, xói mòn đất.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Kết hợp với việc làm cỏ, bón bổ sung thêm mùn núi cho cây bằng cách phủ lên mặt đất gần gốc cây một lớp mùn dày khoảng 2 cm, để giúp cây sinh trưởng tốt và cho năng suất cao. Có thể sử dụng các chế phẩm vi sinh ủ với lá mục, lá khô tại chỗ…để bón bổ sung cho cây.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Những năm mưa ít trong các tháng mùa khô, đất trồng bị khô, cần tưới nước bổ sung để giúp cây sinh trưởng được thuận lợi.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Dọn dẹp cành cây đổ gãy xuống vườn sâm; chăm sóc và khắc phục sớm những trường hợp cây bị tổn thương.</p>\n" +
            "<p style=\"text-align: justify\"><strong>6. Phòng trừ dịch hại</strong></p>\n" +
            "<p style=\"text-align: justify\">Để phòng trừ dịch hại trên cây Sâm Ngọc Linh hiệu quả, phải áp dụng triệt để biện pháp quản lý dịch hại tổng hợp (IPM), chú trọng việc tạo điều kiện tốt nhất cho cây sâm sinh trưởng và phát triển, cụ thể:</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Chọn cây giống phải đạt tiêu chuẩn, khỏe, sạch sâu bệnh.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Chọn đất tốt để trồng, đất có nhiều mùn, không bị úng nước, có độ tàn che từ 70% trở lên.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Tăng cường các biện pháp canh tác như: Vệ sinh vườn, thu gom, cách ly cây bệnh… để hạn chế các đối tượng dịch hại gây hại.</p>\n" +
            "<p style=\"text-align: justify\">&#8211; Thường xuyên kiểm tra, phát hiện sớm các đối tượng dịch hại, xử lý kịp thời bằng các biện pháp thủ công như: cắt tỉa lá bị bệnh, nhổ bỏ và xử lý cây bệnh,…Cần làm bẫy lồng, bẫy kẹp, dụng cụ xua đuổi… hoặc dùng nilon, lưới để ngăn các động vật gây hại vườn sâm.</p>\n" +
            "<p style=\"text-align: justify\">* Đối với những vườn giữ giống, nhân giống, vườn ươm khi có nguy cơ dịch hại nặng, có thể sử dụng thuốc BVTV (ưu tiên sử dụng các loại thuốc sinh học) theo hướng dẫn của cơ quan chuyên môn để bảo vệ tối đa nguồn giống.</p>\n" +
            "<p style=\"text-align: justify\">Trồng sâm đúng hướng dẫn kỹ thuật, trồng lan trên mặt đất tự nhiên (không lên luống) để tránh nước mưa tạo thành dòng chảy hay đất trong luống sâm quá ẩm ướt sau mưa nhằm hạn chế bệnh hại sau này, đặc biệt đối với bệnh do vi khuẩn gây hại.</p>\n" +
            "<p style=\"text-align: justify\">Ngoài ra, quả sâm có các đối tượng như chuột, chim và các động vật khác rất thích ăn. Vì vậy, khi cây kết quả, phải làm túi lưới bọc chùm quả. Túi lưới được gắn vào 1 que chắc chắn (que dài hay ngắn tùy thuộc độ cao của chùm quả), que được cắm chắc xuống đất. Ngoài tác dụng bảo vệ các đối tượng gây hại, cọc túi lưới có tác dụng giữ cho cây không bị gió, mưa lay đổ do chùm quả nặng.</p>\n" +
            "<p style=\"text-align: justify\"><strong>7. Thu hoạch</strong></p>\n" +
            "<p style=\"text-align: justify\">Sâm Ngọc Linh trồng từ cây giống sau 6 năm có thể thu hoạch được, tuy nhiên năng suất, chất lượng và hiệu quả chưa cao, nên thu hoạch củ khi sâm đạt từ 8 năm tuổi trở lên, thu vào tháng 10 &#8211; 12 (khi cây ngủ đông).</p>\n" +
            "<p style=\"text-align: justify\">Trên đây là hướng dẫn tạm thời kỹ thuật trồng và chăm sóc Sâm Ngọc Linh dưới tán rừng theo phương pháp mô phỏng các điều kiện sống của Sâm hoang dã, bảo đảm phát triển Sâm Ngọc Linh trồng bền vững, hạn chế tối đa các tác động suy giảm môi trường rừng. Yêu cầu mọi đối tượng trồng Sâm dưới tán rừng phải tuân thủ hướng dẫn này; trong quá trình thực hiện nếu có vướng mắc đề nghị phản ánh để có điều chỉnh, bổ sung cho phù hợp.</p>\n";


    public AcknowledgeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_acknowledge, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.text_source);

        //set content
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(source, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(source));
        }
    }
}
