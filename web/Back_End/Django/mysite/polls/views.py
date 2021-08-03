from django.http import HttpResponse
from django.template import loader
from django.utils.regex_helper import contains
from django.views.decorators.csrf import csrf_exempt

from .models import Question
from django.views import View, generic
from django.contrib.auth.decorators import login_required, permission_required
from django.contrib.auth.mixins import LoginRequiredMixin
from django.http import JsonResponse
import datetime
import json

@login_required
def index(request):
    latest_question_list = Question.objects.order_by('-pub_date')[:]
    template = loader.get_template('polls/index.html')
    context = {
        'latest_question_list': latest_question_list,
    }
    return HttpResponse(template.render(context, request))


# override the get_queryset() method to change the list of records returned
class IndexView(LoginRequiredMixin,generic.ListView):
    template_name = 'polls/index.html'
    context_object_name = 'latest_question_list'
    
    def get_queryset(self):
        """Return the last five published questions."""
        return Question.objects.order_by('-pub_date')[:5]
    def get_context_data(self, **kwargs):
        # Number of visits to this view, as counted in the session variable.
        num_visits = self.request.session.get('num_visits', 0)
        self.request.session['num_visits'] = num_visits + 1
        # Call the base implementation first to get the context
        context = super(IndexView, self).get_context_data(**kwargs)
        # Create any data and add it to the context
        context['num_visits'] = self.request.session['num_visits']
        return context

# Rest API
from django.utils.decorators import method_decorator
from django.http import QueryDict

@method_decorator(csrf_exempt, name='dispatch')
class API(View):
    #model = Pallet
    def get(self, *args, **kwargs):
        print(kwargs)
        quest = Question.objects.order_by('-pub_date')[:]

        if('num' in kwargs):
            num = kwargs['num']
            if num<len(quest):
                return JsonResponse(quest[num].__str__(), safe=False, status=200)
            else:
                return JsonResponse({}, safe=False, status=200)

        return JsonResponse([q.__str__() for q in quest], safe=False, status=200)
    
    def post(self, request, **kwargs):
        #print(self.request.POST)
        data = json.loads(request.body)
        print(data)
        if 'question_text' in data:
            Question.objects.create(question_text=data['question_text'],pub_date=datetime.date.today())
            return JsonResponse('success', safe=False, status=200)
        return JsonResponse('fail', safe=False, status=200)
    def put(self, request, **kwargs):
        quests = Question.objects.order_by('-pub_date')[:]
        data = json.loads(request.body)
        print(data)
        if('num' in kwargs):
            num = kwargs['num']
            if num<len(quests) and 'question_text' in data:
                #quest[num].question_text = data['question_text']
                quest = Question.objects.order_by('-pub_date')[num]
                quest.question_text = data['question_text']
                quest.save()
                return JsonResponse(quest.__str__(), safe=False, status=200)
            else:
                return JsonResponse('fail', safe=False, status=200)

    def delete(self, request, **kwargs):
        quests = Question.objects.order_by('-pub_date')[:]
        data = json.loads(request.body)
        print(data)
        if('num' in kwargs):
            num = kwargs['num']
            if num<len(quests):
                #quest[num].question_text = data['question_text']
                quest = Question.objects.order_by('-pub_date')[num]
                quest.delete()
                return JsonResponse('success', safe=False, status=200)
            else:
                return JsonResponse('fail', safe=False, status=200)