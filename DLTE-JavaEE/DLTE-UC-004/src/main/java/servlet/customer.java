package servlet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class customer{
    private int customer_Id,customer_pin;
    private String customer_name, account_number, pan, customer_address;
    private long aadhaar,mobile;
    private double acc_balance,acc_number;
}




