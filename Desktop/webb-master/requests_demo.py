import re
import requests

#match(从字符串开头开始匹配):
text = 'hello 123 weq 12mle'
reg = re.match('hell.*?(\d+).*mle$',text)
print(type(reg))
print(reg.group(1))
print(reg.span())   

#修饰符 re.S等等
text2 = '''hello 123
weq 12mel'''
reg2 = re.match('hell.*?mel$',text2,re.S)
print(reg2)

#转义符: \
text3 = '(百度) com.com'
reg3 = re.match('\(百度\)\s.*\.',text3)
print(reg3.group())

# search相匹配的所有字符串:
text4 = '123 (百度) com.com'
reg4 = re.search('\(百度\)\s.*\.', text4)
print(reg4.group())

#findall(相匹配的所有字符串, 只包含组（）里的字符串,两组以上保存为元组，一组保存为字符串（不额外增加元组）):
text5 = 'hello 123hello 123hello 123hello 123'
reg5 = re.findall('(hello)\s(\d*)', text5)
reg7 = re.findall('(hello)\s', text5)
print(reg5)
print(reg7)

#sub(替换字符串):
text6 = 'hello 123hello 123hello 123hello 123'
reg6 = re.sub('(\d+)',' ',text6)
print(reg6)

#compiler, 编译创建正则表达式对象:
text8 = 'hello 123hello 123hello 123hello 123'
reg_com = re.compile('(\d+)',re.I)
reg8 = re.sub(reg_com, ' ', text8)
print(reg8)
