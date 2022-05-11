export class Contract{
  id: number;
  contractStartDate: string;
  contractEndDate: string;
  contractDeposit: number;
  contractTotalMoney: number;
  employee: string;
  customer: string;
  service: string;
  // tslint:disable-next-line:max-line-length
  constructor(id: number, contractStartDate: string, contractEndDate: string, contractDeposit: number, contractTotalMoney: number, employee: string, customer: string, service: string) {
    this.id = id;
    this.contractStartDate = contractStartDate;
    this.contractEndDate = contractEndDate;
    this.contractDeposit = contractDeposit;
    this.contractTotalMoney = contractTotalMoney;
    this.employee = employee;
    this.customer = customer;
    this.service = service;
  }
}
