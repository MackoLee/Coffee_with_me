from rest_framework import viewsets
from .models import *
from .serializers import *

# Create your views here.
class UsersViewSet(viewsets.ModelViewSet):
    queryset = Users.objects.order_by('-id')
    serializer_class = UsersSerializer

class StoresViewSet(viewsets.ModelViewSet):
    queryset = Stores.objects.all()
    serializer_class = StoresSerializer

class AViewSet(viewsets.ModelViewSet):
    queryset = A.objects.all()
    serializer_class = ASerializer