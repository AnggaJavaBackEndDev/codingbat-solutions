public int loneSum(int a, int b, int c) {
  int hasil=0;
  if(a!=b && a!=c) hasil+=a;
  if(b!=a && b!=c) hasil+=b;
  if(c!=a && c!=b) hasil+=c;
  return hasil;
}
