from django.urls import path,include
from rest_framework.routers import DefaultRouter
from .views import *

#router
router= DefaultRouter()
router.register('user',UsersViewSet)

urlpatterns = [
    path('api/',include(router.urls)),
]
