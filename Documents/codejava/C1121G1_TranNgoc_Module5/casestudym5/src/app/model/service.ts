export class Service{
  id: number;
  serviceCode: string;
  serviceName: string;
  serviceArea: number;
  serviceCost: number;
  serviceMaxPeople: number;
  standardRoom: string;
  descritionOtherConvenience: string;
  poolArea: string;
  numberOdFloors: string;
  rentType: string;
  // tslint:disable-next-line:max-line-length
  constructor(id: number, serviceCode: string, serviceName: string, serviceArea: number, serviceCost: number, serviceMaxPeople: number, standardRoom: string, descritionOtherConvenience: string, poolArea: string, numberOdFloors: string, rentType: string) {
    this.id = id;
    this.serviceCode = serviceCode;
    this.serviceName = serviceName;
    this.serviceArea = serviceArea;
    this.serviceCost = serviceCost;
    this.serviceMaxPeople = serviceMaxPeople;
    this.standardRoom = standardRoom;
    this.descritionOtherConvenience = descritionOtherConvenience;
    this.poolArea = poolArea;
    this.numberOdFloors = numberOdFloors;
    this.rentType = rentType;
  }
}
