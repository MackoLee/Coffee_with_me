from rest_framework import serializers
from .models import *

class UsersSerializer(serializers.ModelSerializer):
    class Meta:
        model = Users
        fields = '__all__' #['name','age']

class StoresSerializer(serializers.ModelSerializer):
    class Meta:
        model = Stores
        fields= '__all__'
class ASerializer(serializers.ModelSerializer):
    class Meta:
        model = A
        fields= '__all__'