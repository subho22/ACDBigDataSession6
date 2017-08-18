package mapreduce.assignment.task8;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
 
public class TV implements WritableComparable<TV> {
 
    private String company;
    private int sold;
 
    public String getCompany() {
        return company;
    }
 
    public int getsold() {
        return sold;
    }
 
    public void set(String company, int sold) {
        this.company = company;
        this.sold = sold;
    }
 
    @Override
    public void readFields(DataInput in) throws IOException {
    	company = in.readUTF();
    	sold = in.readInt();
    }
 
    @Override
    public void write(DataOutput out) throws IOException {
    	out.writeUTF(company);
    	out.writeInt(sold);
    }
 
    @Override
    public String toString() {
        return company + "\t" + sold;
    }
 
    @Override
    public int compareTo(TV tv) {
        int cmp = sold.compareTo(tv.sold);
 
        if (cmp != 0) {
            return cmp;
        }
 
        return (-1) * (sold- tv.getsold());
    }
 
    @Override
    public int hashCode(){
        return company.hashCode();
    }
 
  
}