
package com.chase.payment.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "processPayment", namespace = "http://payment.chase.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processPayment", namespace = "http://payment.chase.com/")
public class ProcessPayment {

    @XmlElement(name = "arg0", namespace = "")
    private com.chase.payment.CreditCardPayment arg0;

    /**
     * 
     * @return
     *     returns CreditCardPayment
     */
    public com.chase.payment.CreditCardPayment getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.chase.payment.CreditCardPayment arg0) {
        this.arg0 = arg0;
    }

}
