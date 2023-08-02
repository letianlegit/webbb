var person= {
    name : "chen",
    fullName : function(){
        return this.name;
    }
}

x = 2;

console.log(this.x);

var txt="123";
var lengthOfTxt = txt.length;

var a = 5, b = 5;

if (true)
{
    console.log(a===b);
}

var person={fname:"Bill",lname:"Gates",age:56}; 

for (x in person)  // x 为属性名
{
    txt=txt + person[x];
}

console.log(txt)

list: 
{
    document.write(x + "12" + "<br>"); 
    document.write(x + "<br>"); 
    document.write(x + "<br>"); 
    break list;//标签引用
    document.write(cars[3] + "<br>"); 
    document.write(cars[4] + "<br>"); 
    document.write(cars[5] + "<br>"); 
}