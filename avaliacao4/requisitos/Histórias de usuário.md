# Histórias de Usuário

## 01

Como: Profissional de saude

Eu quero: Realizar meu cadastro na plataforma

Dado: Quero utilizar a plataforma;

Quando: Entrar na aplicação;
E: Entrar na tela de cadastro;
E: Fornecer minhas informações de emails, senha, nome, CRM, especialidade, local de trabalho e endereço

Então: Ficar liberado para realizar o login;

## 02

Como: Profissional de saude

Eu quero: Realizar login na plataforma

Dado: Quero utilizar a plataforma;

Quando: Entrar na aplicação;
E: Entrar na tela de login;
E: Passar meu email e senha;

Então: Conseguir acessa a minha pagina principal;
E: Ver minhas conversas;
E: Entrar em contato com outros médicos;

## 03

Como: Profissional de saude

Eu quero: Enviar mensagens para outros profissionais de saude;

Dado: Necessito de trocar informações médicas com outros profissionais;

Quando: Estiver logado;
E: Selecionar um médico para enviar mensagens;
E: Escrever a mensagem ou anexar um arquivo;
E: Clicar no botão de enviar;

Então: Receber as mensagens que o outro profissional enviar em tempo real;

## 04

Como: Profissional de saude

Eu quero: Poder filtrar profissionais de saude;

Dado: Necessito de ter uma lista de profissionais mais reduzida e focada para eu poder escolher o profissional correto;

Quando: Estiver logado;
E: Clicar no botão do filtro;
E: Selecionar uma especialidade;
E/OU: Selecionar um endereço ou região;
E/OU: Escrever um nome de um profissional;
E: Clicar no botão de filtrar;

Então: Os médicos disponiveis para enviar mensagens será apenas dos que corresponderem aos filtros passados;

## 05

Como: Profissional de saude

Eu quero: Poder escolher meu grau de vizibilidade;

Dado: Não quero acabar me sobrecarregando de mensagens ou desejo receber apenas mensagens especificas;

Quando: Estiver logado;
E: Clicar no botão de vizibilidade;
E: Selecionar quais especialidades podem me contatar;
E/OU: Selecionar uma região que pode me contatar;
E: Clicar no botão de concluir;

Então: Os médicos fora do meu filtro não poderão me visualizar e enviar mensagens;

## 06

Como: Profissional de saude

Eu quero: Finalizar conversas que concluiram seu objetivo;

Dado: Não quero acabar me sobrecarregando de mensagens ou desejo receber apenas mensagens especificas;

Quando: Estiver logado;
E: Dentro de uma conversa;
E: Clicar no botão finalizar;
E: COnfirmar a finalização;

Então: A conversa é apagada;

## 07

Como: Administrador 

Eu quero: Permitir o cadastro de novos profissionais;

Dado: O sistema estiver em funcionamento normal, profissionais de saúde podem se cadastrar no mesmo;

Quando: Um profissional se cadastrar;
E: Dentro do sistema;
E: Informando todos os dados de forma correta;
E: Confirmar o cadastro;

Então: O cadastro deve ser feito, salvando todas as informações;

## 08

Como: Administrador 

Eu quero: Deletar profissionais de saúde que foram desligados do serviço;

Dado: Um determinado funcionário previamente cadastrado no sistema, não faz mais parte daquele nicho;

Quando: Eu quiser retirar o devido trabalhador;
E: Dentro do sistema;
E: Escolhendo corretamente o profissional;
E: Confirmar a exclusão do mesmo;

Então: O usuário deve ser deletado, retirando todas as informações do sistema sobre aquele profissional;
