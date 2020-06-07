from rest_framework import serializers
from .models import book, bookNumber, char, author


class authorSerrializer(serializers.ModelSerializer):
    class Meta:
        model = author
        fields = ['id','name']
class CharSerrializer(serializers.ModelSerializer):
    class Meta:
        model = char
        fields = ['id','name']
class BookNumberSerrializer(serializers.ModelSerializer):
    class Meta:
        model = bookNumber
        fields = ['id','isbn']
class BookSerrializer(serializers.ModelSerializer):
    number = BookNumberSerrializer(many=False)
    char = CharSerrializer(many=True)
    author = authorSerrializer(many=True)
    class Meta:
        model = book
        fields = ['id','title','number','char','author']
