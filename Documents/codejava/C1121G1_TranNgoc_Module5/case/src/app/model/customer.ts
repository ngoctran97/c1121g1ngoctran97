export class Customer{
  id: number;
  customerCode: string;
  customerName: string;
  customerDateOfBirth: string;
  customerGender: string;
  customerIdCard: number;
  customerPhone: string;
  customerEmail: string;
  customerAddress: string;
  customerTypeId: string;
  // tslint:disable-next-line:max-line-length
  constructor(id: number, customerCode: string, customerName: string, customerDateOfBirth: string, customerGender: string, customerIdCard: number, customerPhone: string, customerEmail: string, customerAddress: string, customerTypeId: string) {
    this.id = id;
    this.customerCode = customerCode;
    this.customerName = customerName;
    this.customerDateOfBirth = customerDateOfBirth;
    this.customerGender = customerGender;
    this.customerIdCard = customerIdCard;
    this.customerPhone = customerPhone;
    this.customerEmail = customerEmail;
    this.customerAddress = customerAddress;
    this.customerTypeId = customerTypeId;
  }
}
