import{c as G,a as P,ag as K,ah as V,d as R,u as Q,g as L,ai as X,h as k,aj as Z,ak as ee,i as te,al as se,l as b,am as ne,T as ae,a2 as ie,A as oe,O as le,a1 as W,r as w,B as x,C as U,J as e,Q as n,S as i,D as t,N as D,W as r,ab as y,ac as _,R as re,_ as $,an as ce,I as ue,a8 as de,ao as pe,P as T,ap as me,aq as E,$ as ve,F as M,U as O,ar as fe,as as he,at as j,au as ge,av as ye}from"./index-6b9ba026.js";const _e=G([G("@keyframes spin-rotate",`
 from {
 transform: rotate(0);
 }
 to {
 transform: rotate(360deg);
 }
 `),P("spin-container",{position:"relative"},[P("spin-body",`
 position: absolute;
 top: 50%;
 left: 50%;
 transform: translateX(-50%) translateY(-50%);
 `,[K()])]),P("spin-body",`
 display: inline-flex;
 align-items: center;
 justify-content: center;
 flex-direction: column;
 `),P("spin",`
 display: inline-flex;
 height: var(--n-size);
 width: var(--n-size);
 font-size: var(--n-size);
 color: var(--n-color);
 `,[V("rotate",`
 animation: spin-rotate 2s linear infinite;
 `)]),P("spin-description",`
 display: inline-block;
 font-size: var(--n-font-size);
 color: var(--n-text-color);
 transition: color .3s var(--n-bezier);
 margin-top: 8px;
 `),P("spin-content",`
 opacity: 1;
 transition: opacity .3s var(--n-bezier);
 pointer-events: all;
 `,[V("spinning",`
 user-select: none;
 -webkit-user-select: none;
 pointer-events: none;
 opacity: var(--n-opacity-spinning);
 `)])]),ke={small:20,medium:18,large:16},be=Object.assign(Object.assign({},L.props),{description:String,stroke:String,size:{type:[String,Number],default:"medium"},show:{type:Boolean,default:!0},strokeWidth:Number,rotate:{type:Boolean,default:!0},spinning:{type:Boolean,validator:()=>!0,default:void 0}}),xe=R({name:"Spin",props:be,setup(d){const{mergedClsPrefixRef:u,inlineThemeDisabled:o}=Q(d),a=L("Spin","-spin",_e,X,d,u),v=k(()=>{const{size:s}=d,{common:{cubicBezierEaseInOut:c},self:h}=a.value,{opacitySpinning:g,color:C,textColor:S}=h,z=typeof s=="number"?Z(s):h[ee("size",s)];return{"--n-bezier":c,"--n-opacity-spinning":g,"--n-size":z,"--n-color":C,"--n-text-color":S}}),f=o?te("spin",k(()=>{const{size:s}=d;return typeof s=="number"?String(s):s[0]}),v,d):void 0;return{mergedClsPrefix:u,compitableShow:se(d,["spinning","show"]),mergedStrokeWidth:k(()=>{const{strokeWidth:s}=d;if(s!==void 0)return s;const{size:c}=d;return ke[typeof c=="number"?"medium":c]}),cssVars:o?void 0:v,themeClass:f==null?void 0:f.themeClass,onRender:f==null?void 0:f.onRender}},render(){var d,u;const{$slots:o,mergedClsPrefix:a,description:v}=this,f=o.icon&&this.rotate,s=(v||o.description)&&b("div",{class:`${a}-spin-description`},v||((d=o.description)===null||d===void 0?void 0:d.call(o))),c=o.icon?b("div",{class:[`${a}-spin-body`,this.themeClass]},b("div",{class:[`${a}-spin`,f&&`${a}-spin--rotate`],style:o.default?"":this.cssVars},o.icon()),s):b("div",{class:[`${a}-spin-body`,this.themeClass]},b(ne,{clsPrefix:a,style:o.default?"":this.cssVars,stroke:this.stroke,"stroke-width":this.mergedStrokeWidth,class:`${a}-spin`}),s);return(u=this.onRender)===null||u===void 0||u.call(this),o.default?b("div",{class:[`${a}-spin-container`,this.themeClass],style:this.cssVars},b("div",{class:[`${a}-spin-content`,this.compitableShow&&`${a}-spin-content--spinning`]},o),b(ae,{name:"fade-in-transition"},{default:()=>this.compitableShow?c:null})):c}});function $e(){const d=new Date,u=d.getDate(),o=d.getMonth()+1;return`${d.getFullYear()}-${o}-${u}`}const we={class:"p-4 space-y-5 min-h-[200px]"},Ce={class:"space-y-6"},Se={class:"flex items-center space-x-4"},ze={class:"flex-shrink-0 w-[100px]"},Ie={class:"flex-1"},Ne={class:"flex items-center space-x-4"},Pe={class:"flex-shrink-0 w-[100px]"},Te={class:"w-[200px]"},Be={class:"flex items-center space-x-4"},Ue={class:"flex-shrink-0 w-[100px]"},Re={class:"flex-1"},Ae={class:"flex-shrink-0 w-[100px]"},De={class:"flex flex-wrap items-center gap-4"},je={class:"flex items-center space-x-4"},Me={class:"flex-shrink-0 w-[100px]"},Oe={class:"flex flex-wrap items-center gap-4"},Ge={class:"flex items-center space-x-4"},Ve={class:"flex-shrink-0 w-[100px]"},Le={class:"flex flex-wrap items-center gap-4"},We={class:"flex items-center space-x-4"},Ee={class:"flex-shrink-0 w-[100px]"},Fe=R({__name:"General",setup(d){const u=ie(),o=oe(),{isMobile:a}=le(),v=W(),f=k(()=>u.theme),s=k(()=>o.userInfo),c=w(s.value.avatar??""),h=w(s.value.name??""),g=w(s.value.description??""),C=k({get(){return u.language},set(l){u.setLanguage(l)}}),S=[{label:"Auto",key:"auto",icon:"ri:contrast-line"},{label:"Light",key:"light",icon:"ri:sun-foggy-line"},{label:"Dark",key:"dark",icon:"ri:moon-foggy-line"}],z=[{label:"简体中文",key:"zh-CN",value:"zh-CN"},{label:"繁體中文",key:"zh-TW",value:"zh-TW"},{label:"English",key:"en-US",value:"en-US"}];function I(l){o.updateUserInfo(l),v.success(T("common.success"))}function F(){o.resetUserInfo(),v.success(T("common.success")),window.location.reload()}function J(){const l=$e(),p=localStorage.getItem("chatStorage")||"{}",m=JSON.stringify(JSON.parse(p),null,2),N=new Blob([m],{type:"application/json"}),A=URL.createObjectURL(N),B=document.createElement("a");B.href=A,B.download=`chat-store_${l}.json`,document.body.appendChild(B),B.click(),document.body.removeChild(B)}function H(l){const p=l.target;if(!p||!p.files)return;const m=p.files[0];if(!m)return;const N=new FileReader;N.onload=()=>{try{const A=JSON.parse(N.result);localStorage.setItem("chatStorage",JSON.stringify(A)),v.success(T("common.success")),location.reload()}catch{v.error(T("common.invalidFileFormat"))}},N.readAsText(m)}function Y(){localStorage.removeItem("chatStorage"),location.reload()}function q(){const l=document.getElementById("fileInput");l&&l.click()}return(l,p)=>(x(),U("div",we,[e("div",Ce,[e("div",Se,[e("span",ze,n(l.$t("setting.avatarLink")),1),e("div",Ie,[i(t(D),{value:c.value,"onUpdate:value":p[0]||(p[0]=m=>c.value=m),placeholder:""},null,8,["value"])]),i(t(_),{size:"tiny",text:"",type:"primary",onClick:p[1]||(p[1]=m=>I({avatar:c.value}))},{default:r(()=>[y(n(l.$t("common.save")),1)]),_:1})]),e("div",Ne,[e("span",Pe,n(l.$t("setting.name")),1),e("div",Te,[i(t(D),{value:h.value,"onUpdate:value":p[2]||(p[2]=m=>h.value=m),placeholder:""},null,8,["value"])]),i(t(_),{size:"tiny",text:"",type:"primary",onClick:p[3]||(p[3]=m=>I({name:h.value}))},{default:r(()=>[y(n(l.$t("common.save")),1)]),_:1})]),e("div",Be,[e("span",Ue,n(l.$t("setting.description")),1),e("div",Re,[i(t(D),{value:g.value,"onUpdate:value":p[4]||(p[4]=m=>g.value=m),placeholder:""},null,8,["value"])]),i(t(_),{size:"tiny",text:"",type:"primary",onClick:p[5]||(p[5]=m=>I({description:g.value}))},{default:r(()=>[y(n(l.$t("common.save")),1)]),_:1})]),e("div",{class:re(["flex items-center space-x-4",t(a)&&"items-start"])},[e("span",Ae,n(l.$t("setting.chatHistory")),1),e("div",De,[i(t(_),{size:"small",onClick:J},{icon:r(()=>[i(t($),{icon:"ri:download-2-fill"})]),default:r(()=>[y(" "+n(l.$t("common.export")),1)]),_:1}),e("input",{id:"fileInput",type:"file",style:{display:"none"},onChange:H},null,32),i(t(_),{size:"small",onClick:q},{icon:r(()=>[i(t($),{icon:"ri:upload-2-fill"})]),default:r(()=>[y(" "+n(l.$t("common.import")),1)]),_:1}),i(t(ce),{placement:"bottom",onPositiveClick:Y},{trigger:r(()=>[i(t(_),{size:"small"},{icon:r(()=>[i(t($),{icon:"ri:close-circle-line"})]),default:r(()=>[y(" "+n(l.$t("common.clear")),1)]),_:1})]),default:r(()=>[y(" "+n(l.$t("chat.clearHistoryConfirm")),1)]),_:1})])],2),e("div",je,[e("span",Me,n(l.$t("setting.theme")),1),e("div",Oe,[(x(),U(ue,null,de(S,m=>i(t(_),{key:m.key,size:"small",type:m.key===t(f)?"primary":void 0,onClick:N=>t(u).setTheme(m.key)},{icon:r(()=>[i(t($),{icon:m.icon},null,8,["icon"])]),_:2},1032,["type","onClick"])),64))])]),e("div",Ge,[e("span",Ve,n(l.$t("setting.language")),1),e("div",Le,[i(t(pe),{style:{width:"140px"},value:t(C),options:z,onUpdateValue:p[6]||(p[6]=m=>t(u).setLanguage(m))},null,8,["value"])])]),e("div",We,[e("span",Ee,n(l.$t("setting.resetUserInfo")),1),i(t(_),{size:"small",onClick:F},{default:r(()=>[y(n(l.$t("common.reset")),1)]),_:1})])])]))}}),Je={class:"p-4 space-y-5 min-h-[200px]"},He={class:"space-y-6"},Ye={class:"flex items-center space-x-4"},qe={class:"flex-shrink-0 w-[100px]"},Ke={class:"flex-1"},Qe={class:"flex items-center space-x-4"},Xe=e("span",{class:"flex-shrink-0 w-[100px]"}," ",-1),Ze=R({__name:"Advanced",setup(d){const u=me(),o=W(),a=w(u.systemMessage??"");function v(s){u.updateSetting(s),o.success(T("common.success"))}function f(){u.resetSetting(),o.success(T("common.success")),window.location.reload()}return(s,c)=>(x(),U("div",Je,[e("div",He,[e("div",Ye,[e("span",qe,n(s.$t("setting.role")),1),e("div",Ke,[i(t(D),{value:a.value,"onUpdate:value":c[0]||(c[0]=h=>a.value=h),placeholder:""},null,8,["value"])]),i(t(_),{size:"tiny",text:"",type:"primary",onClick:c[1]||(c[1]=h=>v({systemMessage:a.value}))},{default:r(()=>[y(n(s.$t("common.save")),1)]),_:1})]),e("div",Qe,[Xe,i(t(_),{size:"small",onClick:f},{default:r(()=>[y(n(s.$t("common.reset")),1)]),_:1})])])]))}}),et="chatgpt-web",tt="2.10.8",st="ChatGPT Web",nt="ChenZhaoYu <chenzhaoyu1994@gmail.com>",at=["chatgpt-web","chatgpt","chatbot","vue"],it={dev:"vite",build:"run-p type-check build-only",preview:"vite preview","build-only":"vite build","type-check":"vue-tsc --noEmit",lint:"eslint .","lint:fix":"eslint . --fix",bootstrap:"pnpm install && pnpm run common:prepare","common:cleanup":"rimraf node_modules && rimraf pnpm-lock.yaml","common:prepare":"husky install"},ot={"@traptitech/markdown-it-katex":"^3.6.0","@vueuse/core":"^9.13.0","highlight.js":"^11.7.0",html2canvas:"^1.4.1",katex:"^0.16.4","markdown-it":"^13.0.1","naive-ui":"^2.34.3",pinia:"^2.0.33",vue:"^3.2.47","vue-i18n":"^9.2.2","vue-router":"^4.1.6"},lt={"@antfu/eslint-config":"^0.35.3","@commitlint/cli":"^17.4.4","@commitlint/config-conventional":"^17.4.4","@iconify/vue":"^4.1.0","@types/crypto-js":"^4.1.1","@types/katex":"^0.16.0","@types/markdown-it":"^12.2.3","@types/markdown-it-link-attributes":"^3.0.1","@types/node":"^18.14.6","@vitejs/plugin-vue":"^4.0.0",autoprefixer:"^10.4.13",axios:"^1.3.4","crypto-js":"^4.1.1",eslint:"^8.35.0",husky:"^8.0.3",less:"^4.1.3","lint-staged":"^13.1.2","markdown-it-link-attributes":"^4.0.1","npm-run-all":"^4.1.5",postcss:"^8.4.21",rimraf:"^4.2.0",tailwindcss:"^3.2.7",typescript:"~4.9.5",vite:"^4.2.0","vite-plugin-pwa":"^0.14.4","vue-tsc":"^1.2.0"},rt={name:et,version:tt,private:!1,description:st,author:nt,keywords:at,scripts:it,dependencies:ot,devDependencies:lt,"lint-staged":{"*.{ts,tsx,vue}":["pnpm lint:fix"]}},ct={class:"p-4 space-y-4"},ut={class:"text-xl font-bold"},dt=e("div",{class:"p-2 space-y-2 rounded-md bg-neutral-100 dark:bg-neutral-700"},[e("p",null,[y(" 此项目开源于 "),e("a",{class:"text-blue-600 dark:text-blue-500",href:"https://github.com/Chanzhaoyu/chatgpt-web",target:"_blank"}," Github "),y(" ，免费且基于 MIT 协议，没有任何形式的付费行为！ ")]),e("p",null," 如果你觉得此项目对你有帮助，请在 Github 帮我点个 Star 或者给予一点赞助，谢谢！ ")],-1),pt={key:0},mt={key:1},vt=R({__name:"About",setup(d){const u=E(),o=w(!1),a=w(),v=k(()=>!!u.isChatGPTAPI);async function f(){try{o.value=!0;const{data:s}=await fe();a.value=s}finally{o.value=!1}}return ve(()=>{f()}),(s,c)=>(x(),M(t(xe),{show:o.value},{default:r(()=>{var h,g,C,S,z,I;return[e("div",ct,[e("h2",ut," Version - "+n(t(rt).version),1),dt,e("p",null,n(s.$t("setting.api"))+"："+n(((h=a.value)==null?void 0:h.apiModel)??"-"),1),t(v)?(x(),U("p",pt,n(s.$t("setting.balance"))+"："+n(((g=a.value)==null?void 0:g.balance)??"-"),1)):O("",!0),t(v)?O("",!0):(x(),U("p",mt,n(s.$t("setting.reverseProxy"))+"："+n(((C=a.value)==null?void 0:C.reverseProxy)??"-"),1)),e("p",null,n(s.$t("setting.timeout"))+"："+n(((S=a.value)==null?void 0:S.timeoutMs)??"-"),1),e("p",null,n(s.$t("setting.socks"))+"："+n(((z=a.value)==null?void 0:z.socksProxy)??"-"),1),e("p",null,n(s.$t("setting.httpsProxy"))+"："+n(((I=a.value)==null?void 0:I.httpsProxy)??"-"),1)])]}),_:1},8,["show"]))}}),ft={class:"ml-2"},ht={class:"min-h-[100px]"},gt={class:"ml-2"},yt={class:"min-h-[100px]"},_t={class:"ml-2"},bt=R({__name:"index",props:{visible:{type:Boolean}},emits:["update:visible"],setup(d,{emit:u}){const o=d,a=E(),v=k(()=>!!a.isChatGPTAPI),f=w("General"),s=k({get(){return o.visible},set(c){u("update:visible",c)}});return(c,h)=>(x(),M(t(ye),{show:t(s),"onUpdate:show":h[1]||(h[1]=g=>ge(s)?s.value=g:null),"auto-focus":!1,preset:"card",style:{width:"95%","max-width":"640px"}},{default:r(()=>[e("div",null,[i(t(he),{value:f.value,"onUpdate:value":h[0]||(h[0]=g=>f.value=g),type:"line",animated:""},{default:r(()=>[i(t(j),{name:"General",tab:"General"},{tab:r(()=>[i(t($),{class:"text-lg",icon:"ri:file-user-line"}),e("span",ft,n(c.$t("setting.general")),1)]),default:r(()=>[e("div",ht,[i(Fe)])]),_:1}),t(v)?(x(),M(t(j),{key:0,name:"Advanced",tab:"Advanced"},{tab:r(()=>[i(t($),{class:"text-lg",icon:"ri:equalizer-line"}),e("span",gt,n(c.$t("setting.advanced")),1)]),default:r(()=>[e("div",yt,[i(Ze)])]),_:1})):O("",!0),i(t(j),{name:"Config",tab:"Config"},{tab:r(()=>[i(t($),{class:"text-lg",icon:"ri:list-settings-line"}),e("span",_t,n(c.$t("setting.config")),1)]),default:r(()=>[i(vt)]),_:1})]),_:1},8,["value"])])]),_:1},8,["show"]))}});export{bt as default};