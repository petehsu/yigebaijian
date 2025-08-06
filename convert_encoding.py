# Python script to convert file encoding to UTF-8

# Define the file paths
input_file = 'app/src/main/java/com/petehsu/yigebaijian/MainActivity.kt'
output_file = 'app/src/main/java/com/petehsu/yigebaijian/MainActivity_converted.kt'

# Read the file with the original encoding
with open(input_file, 'r', encoding='gbk', errors='ignore') as file:
    content = file.read()

# Write the content to a new file with UTF-8 encoding
with open(output_file, 'w', encoding='utf-8') as file:
    file.write(content)

print("File encoding converted to UTF-8 and saved as MainActivity_converted.kt") 