Welcome to the GetVals wiki! 
修改如下两个代码切换获取的值 public String FliePath = "/sys/class/yk_d6t/yk_d6t";//温度传感器 // public String FliePath = "/sys/class/gpio_getVal/gpio_getVal";//电平检测

textView.setText("电平为：" + value);//电平检测 //textView.setText("此时温度为：" + value);//温度检测
