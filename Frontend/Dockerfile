FROM node:18-alpine AS build

WORKDIR /app

COPY package.json package-lock.json* ./

RUN npm install

COPY . .

ARG VITE_API_URL

RUN VITE_API_URL=${VITE_API_URL} npm run build

FROM nginx:alpine

COPY --from=build /app/dist /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
