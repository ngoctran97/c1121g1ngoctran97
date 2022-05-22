import {DangTin} from './dangTin';
import {VungMien} from './vungMien';
import {Huong} from './huong';
import {DanhMuc} from './danhMuc';

export interface Blog{
  id?: number;
  danhMuc?: DanhMuc;
  vungMien?: VungMien;
  banla?: string;
  dangTin?: DangTin;
  tinhTrang?: string;
  diaChi?: string;
  dienTich?: string;
  huong?: Huong;
  tuaDe?: string;
  noiDunh?: string;
  gia?: string;
  trangThai?: string;
  ngayDang?: string;
}
